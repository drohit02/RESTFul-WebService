package com.restapi.webservices.customexception;

public class ApiException extends RuntimeException {

	public ApiException() {
		super();
	}

	public ApiException(String msg) {
		super(msg);
	}

}
