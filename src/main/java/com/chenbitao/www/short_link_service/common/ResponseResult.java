package com.chenbitao.www.short_link_service.common;

import lombok.AllArgsConstructor;
import lombok.Data;

/** 响应结果 */
@AllArgsConstructor
@Data
public class ResponseResult<T> {
	/** 响应代码 */
	private String code;
	/** 响应消息 */
	private String msg;
	/** 响应数据 */
	private T data;
}
