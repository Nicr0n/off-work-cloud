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
	REQUIRE_SUCCESS("1","请求成功"),
	REQUIRE_FAILED("-1","请求失败"),
	INSERT_SUCCESS("1","插入成功"),
	INSERT_FAILED("-1","插入失败"),
	UPDATE_SUCCESS("1","修改成功"),
	UPDATE_FAILED("-1","修改失败"),
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
