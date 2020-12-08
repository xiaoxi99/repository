package com.fh.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fh.user.entity.TSysUser;
import com.fh.user.mapper.TSysUserMapper;
import com.fh.user.service.ITSysUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiang
 * @since 2020-12-07
 */
@Service
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements ITSysUserService {

}
