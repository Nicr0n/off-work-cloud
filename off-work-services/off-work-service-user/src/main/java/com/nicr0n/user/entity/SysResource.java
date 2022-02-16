package com.nicr0n.user.entity;

import com.baomidou.mybatisplus.annotation.*;

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
 * @since 2022/01/26 13:58
 */
@Getter
@Setter
@TableName(value = "sys_resource", autoResultMap = true)
@ApiModel(value = "SysResource对象", description = "")
public class SysResource implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty("资源ID")
	@TableId(value = "resource_id", type = IdType.AUTO)
	private Long resourceId;

	@ApiModelProperty("资源名称")
	@TableField("name")
	private String name;

	@ApiModelProperty("关联菜单，方便编辑权限")
	@TableField("menu_id")
	private Long menuId;

	@ApiModelProperty("HTTP Method")
	@TableField("method")
	private String method;

	@ApiModelProperty("前端权限标识")
	@TableField("permission")
	private String permission;

	@ApiModelProperty("url地址")
	@TableField("url")
	private String url;

	@ApiModelProperty("简介")
	@TableField("description")
	private String description;

	@ApiModelProperty("创建时间")
	@TableField(value = "create_time", fill = FieldFill.INSERT, typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime createTime;

	@ApiModelProperty
	@TableField("create_by")
	private Long createBy;

	@ApiModelProperty("修改时间")
	@TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, typeHandler = TimestamptzTypeHandler.class)
	private LocalDateTime updateTime;

	@ApiModelProperty("修改时间")
	@TableField("update_by")
	private Long updateBy;

	@ApiModelProperty("删除标志(true删除 false未删除)")
	@TableField("delete_flag")
	@TableLogic(value = "false", delval = "true")
	private Boolean deleteFlag;


}
