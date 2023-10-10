package com.nicr0n.user.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.nicr0n.db.handler.TimestamptzTypeHandler;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/2/18  6:01
 * @email: Nicr0nFF@gmail.com
 */
@Schema(description = "路由vo")
@Data
public class RouteItemVO {

	@Schema(description = "菜单ID")
	@TableId(value = "menu_id", type = IdType.AUTO)
	private Long menuId;

	@Schema(description = "菜单名称")
	@TableField("name")
	private String name;

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

	@Schema(description = "重定向地址")
	@TableField("redirect")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String redirect;

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
	private Boolean hidden;

	@Schema(description = "菜单状态(0正常 1停用)")
	@TableField("status")
	private Integer status;

	@Schema(description = "创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime createTime;

	@Schema(description = "创建人ID")
	@TableField("create_by")
	private Long createBy;

	@Schema(description = "修改时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime updateTime;

	@Schema(description = "修改人ID")
	@TableField("update_by")
	private Long updateBy;

	@Schema(description = "额外信息")
	private MetaVO meta;

	@Schema(description = "子路由")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<RouteItemVO> children;

}
