package com.fh.user.service;

import com.fh.user.entity.TSysUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liqiang
 * @since 2020-11-30
 */
public interface ITSysUserService extends IService<TSysUser> {

    TSysUser selectByIdIsPart(Integer id);

    List<Map<String,Object>> queryEducationData();
}
