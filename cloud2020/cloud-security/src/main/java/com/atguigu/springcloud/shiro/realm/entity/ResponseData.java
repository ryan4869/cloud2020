package com.fairyland.core.security.base;

import lombok.Data;

/**
 * code = 0: 正确返回
 * code > 0: 调用时发生错误，需要开发者进行相应的处理。
 * -100 <= code <= -1: 接口调用不能通过接口代理机校验，需要开发者进行相应的处理。
 * code <-100: 系统内部错误，调查问题原因并获得解决方案。
 */
@Data
public class ResponseData<T> {
	private int code;
	private String msg;
	private T data;
	
	public ResponseData() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
	public ResponseData(Builder<T> builder) {
		this.code = builder.code;
		this.msg = builder.msg;
		this.data = builder.data;
	}
	
	public static<T> Builder<T> builder(){
		return new Builder<T>();
	}
	
	public static class Builder<T>{
		private int code;
		private String msg;
		private T data;
		
		public Builder<T> success() {
			this.code = 0;
			return this;
		}
		
		public Builder<T> error(int code) {
			this.code = code;
			return this;
		}
		
		public Builder<T> code(int code) {
			this.code = code;
			return this;
		}
		public Builder<T> msg(String msg) {
			this.msg = msg;
			return this;
		}
		public Builder<T> data(T data) {
			this.data = data;
			return this;
		}
		
		public ResponseData<T> build(){
			return new ResponseData<T>(this);
		}
		
	}
	
}
