package com.restapi.webservices.customexception;

public class APIException extends RuntimeException {

	public APIException() {
		super();
	}

	public APIException(String msg) {
		super(msg);
	}

}
