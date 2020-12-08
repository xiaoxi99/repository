package com.fh.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.fh.user.entity.TSysUser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liqiang
 * @since 2020-12-07
 */
@Repository
@Mapper
public interface TSysUserMapper extends BaseMapper<TSysUser> {

}
