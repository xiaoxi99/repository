package com.fh.logs.entity;

import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liqiang
 * @since 2020-12-03
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class TLogs1203 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("createTime")
    private LocalDateTime createtime;

    @TableField("runTime")
    private Long runtime;

    @TableField("className")
    private String classname;

    @TableField("methodName")
    private String methodname;

    private String args;

    private Integer type;

    private String ipaddress;


}
