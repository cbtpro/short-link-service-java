package com.chenbitao.www.short_link_service.common;

public class ResultUtils {

	private ResultUtils() {
	}

	public static <T> ResponseResult<T> success(T data) {
		return build("200", "success", data);
	}

	public static ResponseResult<Void> success() {
		return build("200", "success", null);
	}

	public static boolean isSuccess(String code) {
		return "200".equals(code);
	}

	public static ResponseResult<Void> failure(String msg) {
		return build("500", msg, null);
	}

	public static ResponseResult<Void> failure(String code, String msg) {
		return build(code, msg, null);
	}

	public static <T> ResponseResult<T> failure(String code, String msg, T data) {
		return build(code, msg, data);
	}

	public static <T> ResponseResult<T> build(String code, String msg, T data) {
		return new ResponseResult<>(code, msg, data);
	}
}
