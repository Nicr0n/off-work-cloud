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
@TableName("sys_resource")
@Schema(description = "SysResource对象")
public class SysResource implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "资源ID")
    @TableId(value = "resource_id", type = IdType.AUTO)
    private Long resourceId;

    @Schema(description = "资源名称")
    @TableField("resource_name")
    private String resourceName;

    @Schema(description = "关联菜单，方便编辑权限")
    @TableField("menu_id")
    private Long menuId;

    @Schema(description = "HTTP Method")
    @TableField("method")
    private String method;

    @Schema(description = "前端权限标识")
    @TableField("permission")
    private String permission;

    @Schema(description = "url地址")
    @TableField("url")
    private String url;

    @Schema(description = "简介")
    @TableField("description")
    private String description;

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
    private Long updateBy;

    @Schema(description = "删除标志(true删除 false未删除)")
    @TableField("delete_flag")
    @TableLogic
    private Boolean deleteFlag;
}
