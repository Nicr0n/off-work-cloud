package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
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
@TableName("sys_role")
@Schema(description = "SysRole对象")
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "角色ID")
    @TableId(value = "role_id", type = IdType.AUTO)
    private Long roleId;

    @Schema(description = "角色名称")
    @TableField("role_name")
    private String roleName;

    @Schema(description = "角色权限code")
    @TableField("code")
    private String code;

    @Schema(description = "角色排序")
    @TableField("sort")
    private String sort;

    @Schema(description = "角色数据作用域")
    @TableField("scope")
    private String scope;

    @Schema(description = "角色描述")
    @TableField("description")
    private String description;

    @Schema(description = "角色状态（0正常 1停用)")
    @TableField("status")
    private Integer status;

    @Schema(description = "创建时间")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @Schema(description = "创建人ID((为NULL则是系统创建))")
    @TableField("create_by")
    private Long createBy;

    @Schema(description = "修改时间")
    @TableField(value = "update_time", fill = FieldFill.UPDATE)
    private LocalDateTime updateTime;

    @Schema(description = "修改人ID(为NULL则是系统创建)")
    @TableField("update_by")
    private Long updateBy;

    @Schema(description = "删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic
    private Boolean deleteFlag;
}
