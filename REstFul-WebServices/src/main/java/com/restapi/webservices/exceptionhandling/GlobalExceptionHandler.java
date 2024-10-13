package com.restapi.webservices.exceptionhandling;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.restapi.webservices.customerrorresponse.ErrorResponse;
import com.restapi.webservices.customexception.ApiException;
import com.restapi.webservices.customexception.ResourceNotFoundException;
import com.restapi.webservices.customexception.UserNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ErrorResponse> handleAllException(Exception ex, WebRequest request) {
		ErrorResponse err = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.BAD_GATEWAY);
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(err);
	}

	@ExceptionHandler(RuntimeException.class)
	public final ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, WebRequest request) {
		ErrorResponse err = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
	}

	@ExceptionHandler(ApiException.class)
	public final ResponseEntity<ErrorResponse> handleApiException(ApiException ex, WebRequest request) {
		ErrorResponse err = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.BAD_REQUEST);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleUserNotFoundException(UserNotFoundException ex,
			WebRequest request) {
		ErrorResponse err = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public final ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex,WebRequest request) {
		ErrorResponse err = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
	}
}
