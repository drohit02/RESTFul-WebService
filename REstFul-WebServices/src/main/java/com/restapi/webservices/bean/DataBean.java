package com.restapi.webservices.bean;

public class DataBean {

	private String message;

	public DataBean() {
		// TODO Auto-generated constructor stub
	}
	
	public DataBean(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "DataBean [message=" + message + "]";
	}
	
	
	
}
