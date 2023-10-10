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
@TableName("sys_menu")
@Schema(description = "SysMenu对象")
public class SysMenu implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "菜单ID")
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Long menuId;

    @Schema(description = "菜单名称")
    @TableField("menu_name")
    private String menuName;

    @Schema(description = "父菜单ID")
    @TableField("parent_id")
    private Long parentId;

    @Schema(description = "排列顺序")
    @TableField("sort")
    private Integer sort;

    @Schema(description = "路由地址")
    @TableField("path")
    private String path;

    @Schema(description = "组件路径")
    @TableField("component")
    private String component;

    @Schema(description = "路由参数")
    @TableField("query")
    private String query;

    @Schema(description = "是否外链(false不是外链 true是外链)")
    @TableField("outer_flag")
    private Boolean outerFlag;

    @Schema(description = "菜单类型")
    @TableField("menu_type")
    private String menuType;

    @Schema(description = "是否隐藏(false隐藏 true不隐藏)")
    @TableField("visible_flag")
    private Boolean visibleFlag;

    @Schema(description = "菜单状态(0正常 1停用)")
    @TableField("status")
    private Integer status;

    @Schema(description = "图标")
    @TableField("icon")
    private String icon;

    @Schema(description = "是否缓存(false不缓存 true缓存)")
    @TableField("cache_flag")
    private Boolean cacheFlag;

    @Schema(description = "在侧边栏中显示的标题")
    @TableField("title")
    private String title;

    @Schema(description = "重定向地址")
    @TableField("redirect")
    private String redirect;

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
