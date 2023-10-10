package com.nicr0n.authorization.entity.po;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author: Nicr0n
 * @date: 2022/4/3  0:30
 * @email: Nicr0nFF@gmail.com
 */

@Schema(description = "用户登录DTO")
@Data
@ToString
@NoArgsConstructor
public class SysUserDTO {

	@Schema(description = "上次登录IP地址")
	@TableField("last_login_ip")
	private String lastLoginIp;

	@Schema(description = "上次登录时间")
	@TableField("last_login_time")
	private Date lastLoginTime;
}
