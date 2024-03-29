package com.nicr0n.gateway.entity.vo;

import com.nicr0n.gateway.constants.StatusCodeEnum;
import lombok.Data;

import java.time.Instant;
import java.time.ZonedDateTime;

/**
 * @author: Nicr0n
 * @date: 2021/10/20  23:39
 * @email: Nicr0nFF@gmail.com
 */
@Data
public class Result<T> {

	private final static String SUCCESS = "成功";

	private final static String FAILED = "失败";

	private Boolean status_flag;

	private String code;

	private String message;

	private Instant time;

	private T data;

	public Result() {
		this.time = ZonedDateTime.now().toInstant();
	}

	public Result(Boolean status_flag, String code, String message) {
		this.status_flag = status_flag;
		this.code = code;
		this.message = message;
		this.time = ZonedDateTime.now().toInstant();
	}

	public Result(String code, String message, T data, Boolean status_flag) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.status_flag = status_flag;
		this.time = ZonedDateTime.now().toInstant();
	}

	/**
	 * 快速创建成功请求结果对象(自定义结果消息)
	 *
	 * @param message 结果消息
	 * @return
	 */
	public static Result success(String message) {
		return new Result(
				true,
				StatusCodeEnum.REQUIRE_SUCCESS.getCode(),
				message
		);
	}

	/**
	 * 按照枚举类创建成功请求结果对象
	 *
	 * @param statusCodeEnum
	 * @return
	 */
	public static Result success(StatusCodeEnum statusCodeEnum) {
		return new Result(
				true,
				statusCodeEnum.getCode(),
				statusCodeEnum.getMessage()
		);
	}

	/**
	 * 快速创建成功请求结果对象(只携带结果数据)
	 *
	 * @param data 结果数据
	 * @return Result
	 */
	public static Result success(Object data) {
		return new Result(
				StatusCodeEnum.REQUIRE_SUCCESS.getCode(),
				StatusCodeEnum.REQUIRE_SUCCESS.getMessage(),
				data,
				true);
	}

	/**
	 * 快速创建成功请求结果对象(不携带结果数据)
	 *
	 * @return Result
	 */
	public static Result result() {
		return new Result(
				true,
				StatusCodeEnum.REQUIRE_SUCCESS.getCode(),
				StatusCodeEnum.REQUIRE_SUCCESS.getMessage()
		);
	}

	/**
	 * 按照枚举类创建失败请求结果对象
	 *
	 * @param statusCodeEnum
	 * @return
	 */
	public static Result fail(StatusCodeEnum statusCodeEnum) {
		return new Result(
				true,
				statusCodeEnum.getCode(),
				statusCodeEnum.getMessage()
		);
	}


	/**
	 * 快速创建失败结果请求对象(只携带返回对象)
	 *
	 * @return Result
	 */
	public static Result fail(Object data) {
		return new Result(
				StatusCodeEnum.REQUIRE_FAIL_INTERNAL.getCode(),
				StatusCodeEnum.REQUIRE_FAIL_INTERNAL.getMessage(),
				data,
				false);
	}

	/**
	 * 快速创建失败结果请求对象(不携带结果数据)
	 *
	 * @return Result
	 */
	public static Result fail() {
		return new Result(
				false,
				StatusCodeEnum.REQUIRE_SUCCESS.getCode(),
				StatusCodeEnum.REQUIRE_SUCCESS.getMessage()
		);
	}

	/**
	 * 快速创建失败请求结果对象(自定义结果消息)
	 *
	 * @param message 结果消息
	 * @return Result
	 */
	public static Result fail(String message) {
		return new Result(
				false,
				StatusCodeEnum.REQUIRE_FAILED.getCode(),
				message
		);
	}

	/**
	 * 快速创建失败请求结果对象(自定义结果消息)
	 *
	 * @param message 结果消息
	 * @return Result
	 */
	public static Result unauthorized(String message) {
		return new Result(
				false,
				StatusCodeEnum.UNAUTHORIZED.getCode(),
				message
		);
	}

	/**
	 * 根据对象是否为空快速创建结果返回对象(不适用于collection)
	 *
	 * @return Result
	 */
	public static Result judgeObject(Object data) {
		if (data == null) {
			return fail();
		} else {
			return success(data);
		}
	}

	public static Result judge(Boolean flag, String message) {
		return flag ? success(message + SUCCESS) : fail(message + FAILED);
	}
}
