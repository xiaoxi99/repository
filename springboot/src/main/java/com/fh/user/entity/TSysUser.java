package com.fh.user.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * <p>
 * 
 * </p>
 *
 * @author liqiang
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_sys_user")
public class TSysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;
    /**
     * 用户名
     */
    @TableField("userName")
    private String username;

    /**
     * 姓名
     */
    @TableField("realName")
    private String realname;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 身份证号
     */
    @TableField("idCard")
    private String idcard;

    /**
     * 性别1男，2女
     */
    private Integer sex;

    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date birthday;

    /**
     * 个人头像
     */
    @TableField("imgUrl")
    private String imgurl;

    /**
     * 学历Id
     */
    @TableField("eduId")
    private Integer eduid;

    /**
     * 省编码
     */
    @TableField("provinceCode")
    private String provincecode;

    /**
     * 市编码
     */
    @TableField("cityCode")
    private String citycode;

    /**
     * 县编码
     */
    @TableField("areaCode")
    private String areacode;

    /**
     * 部门Id
     */
    @TableField("deptId")
    private Integer deptid;

    /**
     * 创建时间
     */
    @TableField("createTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createtime;

    /**
     * 修改时间
     */
    @TableField("updateTime")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updatetime;

    @TableField("saltCode")
    private String saltcode;


}
