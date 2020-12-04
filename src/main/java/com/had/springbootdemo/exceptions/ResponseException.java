package com.had.springbootdemo.exceptions;
import org.springframework.http.HttpStatus;

public class ResponseException extends RuntimeException {
	private HttpStatus httpStatus;
	public ResponseException(String message) {
		super(message);
		this.httpStatus = HttpStatus.BAD_REQUEST;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
