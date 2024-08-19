package com.pavan.emp_manager.exception;

public class ResourceNotFoundException1 extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException1() {
		super();
	}

	public ResourceNotFoundException1(String message) {
		super(message);
	}
}
