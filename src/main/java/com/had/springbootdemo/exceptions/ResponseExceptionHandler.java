package com.had.springbootdemo.exceptions;

import lombok.extern.log4j.Log4j2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Log4j2
public class ResponseExceptionHandler {
	private static Logger log = LoggerFactory.getLogger(ResponseExceptionHandler.class);

	public ResponseExceptionHandler() {
		super();
	}

	/**
	 * Method to return Notes specific exception.
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler(ResponseException.class)
	private final ResponseEntity<Object> handleUserNotFoundException(ResponseException ex, WebRequest request) {
		log.error(ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

	/**
	 * Generic Exception
	 * 
	 * @param ex
	 * @param request
	 * @return ResponseEntity
	 */
	@ExceptionHandler(Exception.class)
	private final ResponseEntity<Object> handleException(Exception ex, WebRequest request) {
		log.error(ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}