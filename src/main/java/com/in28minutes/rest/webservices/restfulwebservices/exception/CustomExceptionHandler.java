package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	 ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
		 
		ExceptionResponse exceptionResp= new ExceptionResponse(new Date(),	 ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResp, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
	
	@ExceptionHandler(UserNotFoundException.class)
	 ResponseEntity<Object> handleUserNotException(Exception ex, WebRequest request){
		 
		ExceptionResponse exceptionResp= new ExceptionResponse(new Date(),	 ex.getMessage(),request.getDescription(false));
		
		return new ResponseEntity<Object>(exceptionResp, HttpStatus.NOT_FOUND);
	 }

}
