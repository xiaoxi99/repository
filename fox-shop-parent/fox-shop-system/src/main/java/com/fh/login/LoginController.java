package com.fh.login;

import com.fh.codeGather.CommonReturn;
import com.fh.user.service.ITSysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loginController")
@Api(value = "登陆控制层")
public class LoginController {

    @Autowired
    private ITSysUserService itSysUserService;

    @PostMapping("/login")
    @ApiOperation("用户登陆")
    public CommonReturn loginUser(String userName, @ApiParam() String passWord){

        return CommonReturn.success(itSysUserService.list());
    }
}
