package com.restapi.webservices.customerrorresponse;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {

	private LocalDateTime timestamp;
	private String msg;
	private HttpStatus status;

	public ErrorResponse() {
		// TODO Auto-generated constructor stub
	}

	public ErrorResponse(LocalDateTime timestamp, String msg, HttpStatus status) {
		this.timestamp = timestamp;
		this.msg = msg;
		this.status = status;
	}

}
