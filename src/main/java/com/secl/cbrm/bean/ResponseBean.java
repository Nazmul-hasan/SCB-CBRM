package com.secl.cbrm.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ResponseBean implements Serializable {

	private boolean isSuccess;
	private String message;
	private Object data;
	private String val;

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	public ResponseBean() {
		this.isSuccess = false;

		this.data = null;
	}

	public boolean isSuccess() {
		return isSuccess;
	}

	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
