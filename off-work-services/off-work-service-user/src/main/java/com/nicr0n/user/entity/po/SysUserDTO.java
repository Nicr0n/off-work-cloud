package com.nicr0n.user.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/12/29    21:23
 * @email: Nicr0nFF@gmail.com
 */
@Getter
@Setter
@Schema(description = "用户修改DTO")
public class SysUserDTO {

    @Schema(description = "部门ID")
    @TableField("department_id")
    private Integer departmentId;

    @Schema(description = "职位ID")
    @TableField("position_id")
    private Integer positionId;

    @Schema(description = "昵称")
    @TableField("nick_name")
    private String nickName;

    @Schema(description = "真实姓名")
    @TableField("name")
    private String name;

    @Schema(description = "手机号")
    @TableField("telephone")
    private String telephone;

    @Schema(description = "头像url")
    @TableField("avatar_url")
    private String avatarUrl;

    @Schema(description = "性别")
    @TableField("gender")
    private Integer gender;

    @Schema(description = "邮箱")
    @TableField("email")
    private String email;

    @Schema(description = "生日")
    @TableField("birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Schema(description = "账户状态（0正常 1停用)")
    @TableField("status")
    private Integer status;

    @Schema(description = "角色ID列表")
    private List<Long> roleIDList;

    @Schema(description = "上次登录IP地址")
    @TableField("last_login_ip")
    private String lastLoginIp;

    @Schema(description = "上次登录时间")
    @TableField("last_login_time")
    private Date lastLoginTime;
}
