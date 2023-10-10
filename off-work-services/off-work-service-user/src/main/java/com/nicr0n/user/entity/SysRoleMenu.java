package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
@TableName("sys_role_menu")
@ApiModel(value = "SysRoleMenu对象", description = "")
@AllArgsConstructor
public class SysRoleMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty("菜单ID")
    @TableField("menu_id")
    private Long menuId;
}
