package com.walter.v2wsmart.exception;

import javax.servlet.ServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<StandardError> objectNotFoundException(CategoryException e, 
			ServletRequest request){
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ProductException e, 
			ServletRequest request){
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
		
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, 
			ServletRequest request){
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(ProductInvalidException.class)
	public ResponseEntity<StandardError> productInvalidException(ProductInvalidException e, 
			ServletRequest request){
		StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(),
				e.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
}
