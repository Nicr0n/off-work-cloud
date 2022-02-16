package com.nicr0n.user.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

/**
 * @author: Nicr0n
 * @date: 2022/2/17  4:51
 * @email: Nicr0nFF@gmail.com
 */
@Getter
@Setter
@ApiModel(value = "资源DTO")
public class SysResourceDTO {

	@ApiModelProperty("资源名称")
	@TableField("name")
	@NotBlank
	private String name;

	@ApiModelProperty("关联菜单，方便编辑权限")
	@TableField("menu_id")
	private Long menuId;

	@ApiModelProperty("HTTP Method")
	@TableField("method")
	@NotBlank
	private String method;

	@ApiModelProperty("前端权限标识")
	@TableField("permission")
	private String permission;

	@ApiModelProperty("url地址")
	@TableField("url")
	@NotBlank
	private String url;

	@ApiModelProperty("简介")
	@TableField("description")
	private String description;
}
