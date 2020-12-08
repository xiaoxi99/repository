package com.fh.login;

import com.fh.utils.codeGather.CommonReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginController")
@Api(value = "登陆控制层")
public class LoginController {

    @PostMapping("/login")
    @ApiOperation("用户登陆")
    public CommonReturn loginUser(String userName,@ApiParam() String passWord){
        System.out.println("asdasd");
        return CommonReturn.success();
    }
}
