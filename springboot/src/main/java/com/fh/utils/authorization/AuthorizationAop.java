package com.fh.utils.authorization;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.fh.utils.JwtUtil;
import com.fh.utils.codeGather.CommonReturn;
import com.fh.utils.codeGather.ReturnCode;
import io.jsonwebtoken.Claims;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@Aspect
@Component
public class AuthorizationAop {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private RedisTemplate redisTemplate;

    private static final String pre_token = "ACCESS_TOKEN:";

    @Around(value = "execution(* com.fh.*.controller..*.*(..)) && @annotation(loginAnnotation)")
    public Object loginAround(ProceedingJoinPoint joinPoint, LoginAnnotation loginAnnotation) throws Throwable {
        Object obj = null;
        //获取请求头部信息中的token值
        String token = request.getHeader("Authorization-token");
        //token 不存在，登陆失效
        if (StringUtils.isBlank(token)) {
            return CommonReturn.error(ReturnCode.LOGIN_DISABLED);
        }
        //判断解析token的方法是否成功，不成功说明token值已过期
        CommonReturn commonReturn = jwtUtil.refToken(token);
        if (commonReturn.getCode() != 200) {
            return commonReturn;
        }
        //获取用户信息
        Claims claims = (Claims) commonReturn.getData();
        Integer userId = (Integer) claims.get("userId");
        String accessKey = pre_token + userId + ":" + token;
        //判断redis中是否存在该条数据
        if (!redisTemplate.hasKey(accessKey)) {
            return CommonReturn.error(ReturnCode.LOGIN_DISABLED);
        }
        //登陆续签,再存进一条数据覆盖
        //当前时间毫秒值
        Long currentTime = System.currentTimeMillis();
        //存进redis中Stirng类型的数据
        redisTemplate.opsForValue().set(accessKey,currentTime);
        //设置该数据过期时间                      2分钟
        redisTemplate.expire(accessKey,2,TimeUnit.MINUTES);

        //执行方法
        try {
            obj = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            throw throwable;
        }

        return obj;
    }
}
