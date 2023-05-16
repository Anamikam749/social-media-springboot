package com.anamikash.socialMedia.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class UniversalControllerAdvice extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<CommonExceptionResponse> userNotFoundExceptionHandler(Exception ex, WebRequest request) {
		
		CommonExceptionResponse commonExceptionResponse = new CommonExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<CommonExceptionResponse>(commonExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PostNotFoundException.class)
	public final ResponseEntity<CommonExceptionResponse> PostNotFoundExceptionHandler(Exception ex, WebRequest request) {
		
		CommonExceptionResponse commonExceptionResponse = new CommonExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<CommonExceptionResponse>(commonExceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
}
