package com.cups.api.viewmodels;

public class ResponseResult<T> {
	private boolean success;
	private T data;
	public ResponseResult() {
		super();
		success = true;
	}
	public ResponseResult(boolean success) {
		super();
		this.success = success;
	}
	public ResponseResult(T data) {
		super();
		success = true;
		this.data = data;
	}
	public ResponseResult(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseResult [success=" + success + ", data=" + data + "]";
	}
	
	

}
