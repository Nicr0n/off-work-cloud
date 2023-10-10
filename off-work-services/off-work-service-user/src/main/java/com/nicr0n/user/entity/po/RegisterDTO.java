package com.nicr0n.user.entity.po;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * @author: Nicr0n
 * @date: 2022/1/12  20:37
 * @email: Nicr0nFF@gmail.com
 */
@Getter
@Setter
@Schema(description = "注册DTO")
public class RegisterDTO {

	/**
	 * 非空
	 * 正则验证: 匹配a-z 0-9 5-15位字符
	 */
	@Schema(description = "用户名")
	@NotBlank
	@Pattern(regexp = "^[a-z0-9]{5,15}$")
	private String username;

	/**
	 * 非空
	 * 正则验证: 密码必须包含数字和字母，且在6-18位之前
	 * 可以包含特殊字符，区分大小写
	 */
	@Schema(description = "密码")
	@NotBlank
	@Pattern(regexp = "^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z\\\\W]{6,18}$")
	private String password;
}
