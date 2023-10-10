package com.nicr0n.user.entity.vo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author: Nicr0n
 * @date: 2022/2/18  6:01
 * @email: Nicr0nFF@gmail.com
 */
@ApiModel(value = "路由vo")
@Data
public class RouteItemVO {

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

	@ApiModelProperty("重定向地址")
	@TableField("redirect")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String redirect;

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
	private Boolean hidden;

	@ApiModelProperty("菜单状态(0正常 1停用)")
	@TableField("status")
	private Integer status;

	@ApiModelProperty("创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT)
	private LocalDateTime createTime;

	@ApiModelProperty("创建人ID")
	@TableField("create_by")
	private Long createBy;

	@ApiModelProperty("修改时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
	private LocalDateTime updateTime;

	@ApiModelProperty("修改人ID")
	@TableField("update_by")
	private Long updateBy;

	@ApiModelProperty("额外信息")
	private MetaVO meta;

	@ApiModelProperty("子路由")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<RouteItemVO> children;

}
