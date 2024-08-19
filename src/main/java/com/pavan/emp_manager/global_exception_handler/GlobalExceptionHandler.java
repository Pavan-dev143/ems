package com.pavan.emp_manager.global_exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pavan.emp_manager.exception.ResourceNotFoundException1;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException1.class)
	public ResponseEntity<String> serviceNotFoundHandler(ResourceNotFoundException1 ex){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
	}
}
