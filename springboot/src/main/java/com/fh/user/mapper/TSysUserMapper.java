package com.fh.user.mapper;

import com.fh.user.entity.TSysUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiang
 * @since 2020-11-30
 */
@Repository
@Mapper
public interface TSysUserMapper extends BaseMapper<TSysUser> {

    TSysUser selectByIdIsPart(Integer id);

    List<Map<String,Object>> queryEducationData();
}
