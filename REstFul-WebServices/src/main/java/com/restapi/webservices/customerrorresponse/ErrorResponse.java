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

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "ErrorResponse [timestamp=" + timestamp + ", msg=" + msg + ", status=" + status + "]";
	}
	
	

}
