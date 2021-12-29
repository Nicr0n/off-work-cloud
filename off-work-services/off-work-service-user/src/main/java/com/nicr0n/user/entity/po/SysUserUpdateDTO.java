package com.nicr0n.user.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2021/12/29    21:23
 * @email: Nicr0nFF@gmail.com
 */
@Getter
@Setter
@ApiModel(value = "用户修改DTO")
public class SysUserUpdateDTO {

    @ApiModelProperty("部门ID")
    @TableField("department_id")
    private Integer departmentId;

    @ApiModelProperty("职位ID")
    @TableField("position_id")
    private Integer positionId;

    @ApiModelProperty("昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("真实姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("头像url")
    @TableField("avatar_url")
    private String avatarUrl;

    @ApiModelProperty("性别")
    @TableField("gender")
    private Integer gender;

    @ApiModelProperty("邮箱")
    @TableField("email")
    private String email;

    @ApiModelProperty("生日")
    @TableField("birthday")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @ApiModelProperty("角色ID列表")
    private List<Integer> roleIDList;
}
