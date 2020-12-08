package com.fh.user.controller;


import com.fh.user.entity.TSysUser;
import com.fh.user.service.ITSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiang
 * @since 2020-12-07
 */
@RestController
@RequestMapping("/user/t-sys-user")
public class TSysUserController {
    @Autowired
    private ITSysUserService itSysUserService;

    @GetMapping
    public List<TSysUser>  queryUser(){
        return itSysUserService.list();
    }

}
