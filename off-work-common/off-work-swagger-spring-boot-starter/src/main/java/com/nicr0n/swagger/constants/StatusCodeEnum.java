package com.nicr0n.swagger.constants;

import lombok.Getter;

/**
 * @author: Nicr0n
 * @date: 2021/10/21  0:06
 * @email: Nicr0nFF@gmail.com
 */
@Getter
/**
 * 返回码枚举类
 */
public enum StatusCodeEnum{
	REQUIRE_SUCCESS("200","请求成功"),
	REQUIRE_FAIL_INTERNAL("500","请求失败，服务器内部错误！请检查控制台日志。");

	/**
	 * http状态码
	 */
	private String code;

	/**
	 * 消息
	 */
	private String message;

	StatusCodeEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}
}
