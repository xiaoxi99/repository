package com.fh.login;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.fh.user.entity.TSysUser;
import com.fh.user.service.ITSysUserService;
import com.fh.utils.JwtUtil;
import com.fh.utils.MD5Util;
import com.fh.utils.codeGather.CommonReturn;
import com.fh.utils.codeGather.ReturnCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/login")
@Api(value = "LoginController", description = "登陆的控制层")
public class LoginController {
    @Resource
    private ITSysUserService itSysUserService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    //redis的操作类，相当于jedisUtil
    private RedisTemplate redisTemplate;

    private static final String pre_token = "ACCESS_TOKEN:";

    @PostMapping
    @ApiOperation("登陆")
    public CommonReturn loginUser(@RequestParam("userName") @ApiParam(value = "用户名", required = true, type = "String") String userName,
                                  @RequestParam("password") @ApiParam(value = "用户密码", required = true, type = "String") String password) {
        TSysUser user = itSysUserService.getOne(new QueryWrapper<TSysUser>().eq("userName", userName));

        if (user == null) {
            return CommonReturn.error(ReturnCode.USER_ISNULL);
        }

        String encode = MD5Util.MD5Encode(password);
        if (!encode.equals(user.getPassword())) {
            return CommonReturn.error(ReturnCode.USER_PASSWORD_ERROR);
        }

        String token = jwtUtil.createToken(user);
        //当前时间毫秒值
        Long currentTime = System.currentTimeMillis();

        String accessKey = pre_token + user.getId() + ":" + token;
        //存进redis中Stirng类型的数据
        redisTemplate.opsForValue().set(accessKey,currentTime);
        //设置该数据过期时间                      2分钟
        redisTemplate.expire(accessKey,2,TimeUnit.MINUTES);

        return CommonReturn.success(token);
    }
}
