package com.nicr0n.user.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "资源DTO")
public class SysResourceDTO {

	@Schema(description = "资源名称")
	@TableField("name")
	@NotBlank
	private String name;

	@Schema(description = "关联菜单，方便编辑权限")
	@TableField("menu_id")
	private Long menuId;

	@Schema(description = "HTTP Method")
	@TableField("method")
	@NotBlank
	private String method;

	@Schema(description = "前端权限标识")
	@TableField("permission")
	private String permission;

	@Schema(description = "url地址")
	@TableField("url")
	@NotBlank
	private String url;

	@Schema(description = "简介")
	@TableField("description")
	private String description;
}
