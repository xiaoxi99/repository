package com.fh.user.service.impl;

import com.fh.user.entity.TSysUser;
import com.fh.user.mapper.TSysUserMapper;
import com.fh.user.service.ITSysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liqiang
 * @since 2020-11-30
 */
@Service
public class TSysUserServiceImpl extends ServiceImpl<TSysUserMapper, TSysUser> implements ITSysUserService {

    @Autowired
    private TSysUserMapper tSysUserMapper;

    @Override
    public TSysUser selectByIdIsPart(Integer id) {
        return tSysUserMapper.selectByIdIsPart(id);
    }

    @Override
    public List<Map<String, Object>> queryEducationData() {
        return tSysUserMapper.queryEducationData();
    }
}
