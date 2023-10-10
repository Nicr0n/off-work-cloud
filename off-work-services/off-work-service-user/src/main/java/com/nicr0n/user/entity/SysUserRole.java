package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
@TableName("sys_user_role")
@ApiModel(value = "SysUserRole对象", description = "")
@AllArgsConstructor
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户ID")
    @TableId("user_id")
    private Long userId;

    @ApiModelProperty("角色ID")
    @TableField("role_id")
    private Long roleId;
}
