package com.employee_api.employeemanager.exception;

public class BadRequestException extends RuntimeException{
	public BadRequestException(String message) {
		super(message);
	}
	
	public BadRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
