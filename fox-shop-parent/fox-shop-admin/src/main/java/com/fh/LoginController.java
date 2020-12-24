package com.fh;

import com.fh.codeGather.CommonReturn;
import com.fh.codeGather.ReturnCode;
import com.fh.umsAdmin.service.IUmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//
import javax.annotation.Resource;

@RestController
@RequestMapping("/loginController")
@Api(value = "登陆控制层")
public class LoginController {

    @Resource
    private IUmsAdminService adminService;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired
    //redis的操作类，相当于jedisUtil
    private RedisTemplate redisTemplate;

    private static final String pre_token = "ACCESS_TOKEN:";

    @PostMapping("/login")
    @ApiOperation("用户登陆")
    public CommonReturn loginUser(@RequestParam("username") @ApiParam(value = "用户名", required = true, type = "String") String username,
                                  @RequestParam("password") @ApiParam(value = "用户密码", required = true, type = "String") String password) {
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            return CommonReturn.error(ReturnCode.USERNAME_PASSWORD_NULL);
        }
        System.out.println("asdasd");
        String token = adminService.login(username, password);
        if (token == null){
            return CommonReturn.error(ReturnCode.LOGIN_DISABLED);
        }

        return CommonReturn.success(token);
    }
}
