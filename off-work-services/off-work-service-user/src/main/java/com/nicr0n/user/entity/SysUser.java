package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author Nicr0n
 * @since 2023/10/09 05:50
 */
@Getter
@Setter
@TableName("sys_user")
@Schema(description = "SysUser对象")
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "用户ID")
    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    @Schema(description = "用户名")
    @TableField("username")
    private String username;

    @Schema(description = "密码")
    @TableField("password")
    private String password;

    @Schema(description = "手机号")
    @TableField("telephone")
    private String telephone;

    @Schema(description = "open_id")
    @TableField("open_id")
    private String openId;

    @Schema(description = "部门ID")
    @TableField("department_id")
    private Long departmentId;

    @Schema(description = "职位ID")
    @TableField("position_id")
    private Long positionId;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "真实姓名")
    @TableField("real_name")
    private String realName;

    @Schema(description = "头像url")
    @TableField("avatar_url")
    private String avatarUrl;

    @Schema(description = "性别")
    @TableField("gender")
    private Integer gender;

    @Schema(description = "email")
    @TableField("email")
    private String email;

    @Schema(description = "生日")
    @TableField("birthday")
    private LocalDate birthday;

    @Schema(description = "账户状态（0正常 1停用)")
    @TableField("status")
    private Integer status;

    @Schema(description = "删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic
    private Byte deleteFlag;

    @Schema(description = "上次登录IP地址")
    @TableField("last_login_ip")
    private String lastLoginIp;

    @Schema(description = "上次登录时间")
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;

    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(description = "创建人ID")
    @TableField("create_by")
    private Long createBy;

    @Schema(description = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @Schema(description = "修改人ID")
    @TableField("update_by")
    private Integer updateBy;
}
