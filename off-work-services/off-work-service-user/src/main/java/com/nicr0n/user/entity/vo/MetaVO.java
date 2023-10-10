package com.nicr0n.user.entity.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author: Nicr0n
 * @date: 2022/2/18  12:29
 * @email: Nicr0nFF@gmail.com
 */
@Data
@Schema(description = "额外信息VO")
public class MetaVO {
	@Schema(description = "在侧边栏中显示的标题")
	@TableField("title")
	private String title;

	@Schema(description = "图标")
	@TableField("icon")
	private String icon;

	@Schema(description = "缓存标识")
	private Boolean noCache;
}
