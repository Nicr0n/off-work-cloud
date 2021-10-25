package com.nicr0n.feign.entity.po;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author Nicr0n
 * @since 2021/10/19 13:32
 */
@Getter
@Setter
//重要 TableName注解必须增加 autoResultMap = true 否则无法处理typeHandler
@TableName(value = "sys_user", autoResultMap = true)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @TableField(value = "username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("telephone")
    private String telephone;

    @TableField("open_id")
    private String openId;

    @TableField("nick_name")
    private String nickName;

    @TableField("name")
    private String name;

    @TableField("avatar_url")
    private String avatarUrl;

    @TableField("gender")
    private Integer gender;

    @TableField("email")
    private String email;

    @TableField("birthday")
    private LocalDate birthday;

    @TableField("status")
    private Integer status;

    @TableField("delete_flag")
    @TableLogic(value = "false", delval = "true")
    private Boolean deleteFlag;

    @TableField("last_login_ip")
    private String lastLoginIp;

    @TableField("last_login_time")
    private Date lastLoginTime;

    @TableField(value = "create_time")
    private LocalDateTime createTime;

    @TableField("create_by")
    private Long createBy;

    @TableField(value = "update_time")
    private LocalDateTime updateTime;

    @TableField("update_by")
    private Long updateBy;


}
