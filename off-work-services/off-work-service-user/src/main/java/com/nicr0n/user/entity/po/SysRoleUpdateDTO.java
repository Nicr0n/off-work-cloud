package com.nicr0n.user.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/1/25    14:24
 * @email: Nicr0nFF@gmail.com
 */
@Getter
@Setter
@ApiModel(value = "角色修改DTO")
public class SysRoleUpdateDTO {

    @ApiModelProperty("角色名称")
    @TableField(value = "name")
    private String name;

    @ApiModelProperty("角色权限code")
    @TableField("code")
    private String code;

    @ApiModelProperty("角色排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("角色数据作用域")
    @TableField("scope")
    private Integer scope;

    @ApiModelProperty("角色描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("角色状态（0正常 1停用)")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("菜单ID列表")
    private List<Long> menuIdList;
}
