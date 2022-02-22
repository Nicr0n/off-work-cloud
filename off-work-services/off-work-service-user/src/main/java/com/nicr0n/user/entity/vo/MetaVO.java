package com.nicr0n.user.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: Nicr0n
 * @date: 2022/2/18  12:29
 * @email: Nicr0nFF@gmail.com
 */
@Data
@ApiModel(value = "额外信息VO")
public class MetaVO {
	@ApiModelProperty("在侧边栏中显示的标题")
	@TableField("title")
	private String title;

	@ApiModelProperty("图标")
	@TableField("icon")
	private String icon;

	@ApiModelProperty("缓存标识")
	private Boolean noCache;
}
