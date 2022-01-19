package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.nicr0n.db.handler.TimestamptzTypeHandler;
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
@TableName(value = "sys_menu", autoResultMap = true)
@ApiModel(value = "SysMenu对象", description = "")
public class SysMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("菜单ID")
	@TableId(value = "menu_id", type = IdType.AUTO)
	private Long menuId;

	@ApiModelProperty("菜单名称")
	@TableField("name")
	private String name;

	@ApiModelProperty("父菜单ID")
	@TableField("parent_id")
	private Long parentId;

	@ApiModelProperty("排列顺序")
	@TableField("sort")
	private Integer sort;

	@ApiModelProperty("路由地址")
	@TableField("path")
	private String path;

	@ApiModelProperty("组件路径")
	@TableField("component")
	private String component;

	@ApiModelProperty("路由参数")
	@TableField("query")
	private String query;

	@ApiModelProperty("是否外链(false不是外链 true是外链)")
	@TableField("outer_flag")
	private Boolean outerFlag;

	@ApiModelProperty("菜单类型")
	@TableField("menu_type")
	private String menuType;

	@ApiModelProperty("是否隐藏(false隐藏 true不隐藏)")
	@TableField("visible_flag")
	private Boolean visibleFlag;

	@ApiModelProperty("菜单状态(0正常 1停用)")
	@TableField("status")
	private Integer status;

	@ApiModelProperty("菜单权限")
	@TableField("permission")
	private String permission;

	@ApiModelProperty("图标")
	@TableField("icon")
	private String icon;

	@ApiModelProperty("创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime createTime;

	@ApiModelProperty("创建人ID")
	@TableField("create_by")
	private Long createBy;

	@ApiModelProperty("修改时间")
	@TableField(value = "update_time", fill = FieldFill.UPDATE, typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime updateTime;

	@ApiModelProperty("修改人ID")
	@TableField("update_by")
	private Long updateBy;

	@ApiModelProperty("删除标志(true删除 false未删除)")
	@TableField("delete_flag")
	@TableLogic(value = "false", delval = "true")
	private Boolean deleteFlag;


}
