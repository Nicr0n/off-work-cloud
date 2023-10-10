package com.nicr0n.user.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/1/25    15:39
 * @email: Nicr0nFF@gmail.com
 */
@Getter
@Setter
@Schema(description = "角色修改DTO")
public class SysRoleDTO {

    @Schema(description = "角色名称")
    @TableField(value = "name")
    @NotBlank
    private String name;

    @Schema(description = "角色权限code")
    @TableField("code")
    private String code;

    @Schema(description = "角色排序")
    @TableField("sort")
    private Integer sort;

    @Schema(description = "角色数据作用域")
    @TableField("scope")
    private Integer scope;

    @Schema(description = "角色描述")
    @TableField("description")
    private String description;

    @Schema(description = "角色状态（0正常 1停用)")
    @TableField("status")
    private Integer status;

    @Schema(description = "菜单ID列表")
    private List<Long> menuIdList;
}
