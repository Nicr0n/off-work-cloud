package com.nicr0n.user.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2021/10/19 13:32
 */
@Getter
@Setter
@TableName("sys_role_department")
@ApiModel(value = "SysRoleDepartment对象", description = "")
public class SysRoleDepartment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("角色ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @ApiModelProperty("部门ID")
    @TableId(value = "department_id", type = IdType.AUTO)
    private Long departmentId;


}