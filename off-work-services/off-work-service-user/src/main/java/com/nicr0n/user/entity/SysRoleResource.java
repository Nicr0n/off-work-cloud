package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author Nicr0n
 * @since 2022/01/26 13:58
 */
@Getter
@Setter
@TableName("sys_role_resource")
@ApiModel(value = "SysRoleResource对象", description = "")
public class SysRoleResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    @TableField("role_id")
    private Long roleId;

    @ApiModelProperty("资源ID")
    @TableField("resource_id")
    private Long resourceId;


}
