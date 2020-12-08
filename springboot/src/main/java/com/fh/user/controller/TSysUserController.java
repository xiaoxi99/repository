package com.fh.user.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fh.config.aop.LogsAnnontation;
import com.fh.user.entity.TSysUser;
import com.fh.user.entity.vo.UserVo;
import com.fh.user.service.ITSysUserService;
import com.fh.utils.OssUtils;
import com.fh.utils.authorization.LoginAnnotation;
import com.fh.utils.codeGather.CommonReturn;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liqiang
 * @since 2020-11-30
 */
@RestController
@RequestMapping("/users")
@Api(tags = "TSysUserController",description = "用户信息操作")
public class TSysUserController {

    @Resource
    private ITSysUserService itSysUserService;

    @GetMapping
    @ApiOperation("获取用户所有信息")
    @LogsAnnontation("查询用户所有信息")
    @LoginAnnotation
    public CommonReturn  queryUserData(Page<TSysUser> page, UserVo userVo, HttpServletRequest request){
        QueryWrapper<TSysUser> wrapper=new QueryWrapper<>();

        if (!StringUtils.isEmpty(userVo.getRealname())){
            wrapper.like("realname","%"+userVo.getRealname()+"%");
        }
        if (userVo.getSex() != null){
            wrapper.eq("sex",userVo.getSex());
        }
        if (!StringUtils.isEmpty(userVo.getStartDate())){
            wrapper.ge("birthday",userVo.getStartDate());
        }
        if (!StringUtils.isEmpty(userVo.getEndDate())){
            wrapper.le("birthday",userVo.getEndDate());
        }

        itSysUserService.page(page,wrapper);
        return CommonReturn.success(page);
    }

    @GetMapping("/education")
    @ApiOperation("获取学历表所有信息")
    public CommonReturn  queryEducationData(){
        List<Map<String,Object>> eduList = itSysUserService.queryEducationData();
        return CommonReturn.success(eduList);
    }

    @GetMapping("/name/{realName}")
    @ApiOperation("根据用户真实姓名查询")                                                               //是否必传      //数据类型
    public CommonReturn  queryUserByRealName(@PathVariable("realName") @ApiParam(value = "用户真实姓名",required = true,type = "String") String realName){
        List<TSysUser> userList = itSysUserService.list(new QueryWrapper<TSysUser>().eq("realName",realName));
        return CommonReturn.success(userList);
    }

    @GetMapping("/id")
    @ApiOperation("根据id查询用户信息")
    public CommonReturn  queryUserById( @ApiParam(value = "用户id",required = true,type = "Integer") Integer id){
        TSysUser user = itSysUserService.selectByIdIsPart(id);
        return CommonReturn.success(user);
    }

    @PostMapping
    @ApiOperation("新增用户信息")
    public CommonReturn  saveTSysUser( @ApiParam(value = "用户数据",required = true,type = "Object") TSysUser tSysUser){
        tSysUser.setCreatetime(new Date());
        tSysUser.setUpdatetime(new Date());
        itSysUserService.save(tSysUser);
        return CommonReturn.success();
    }

    @PutMapping
    @ApiOperation("根据id修改用户信息")
    public CommonReturn  updateTSysUser( @ApiParam(value = "用户数据",required = true,type = "Object") TSysUser tSysUser){
        itSysUserService.updateById(tSysUser);
        return CommonReturn.success();
    }

    @DeleteMapping("/id")
    @ApiOperation("根据id删除用户")
    public CommonReturn  deleteTSysUserById( @ApiParam(value = "用户id",required = true,type = "Integer") Integer id){
        itSysUserService.removeById(id);
        return CommonReturn.success();
    }

    @DeleteMapping("/batch")
    @ApiOperation("根据id集合批量删除用户")
    public CommonReturn deleteTSysUserByIds( @ApiParam(value = "用户id的集合",required = true,type = "Integer") Integer[] ids){
        itSysUserService.removeByIds(Arrays.asList(ids));
        return CommonReturn.success();
    }

    @PostMapping("/upload")
    @ApiOperation("文件上传oss")
    public CommonReturn  uploadPhoto(@RequestParam("file") @ApiParam(value = "上传的文件",required = true,type = "file") MultipartFile file) throws IOException {
        String photoUrl = OssUtils.uploadPhoto("user", file);
        return CommonReturn.success(photoUrl);
    }



}
