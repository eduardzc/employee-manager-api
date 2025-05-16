package com.employee_api.employeemanager.exception;

import java.time.LocalDateTime;

public class CustomErrorResponse {
	
	private int statusCode;
	private String message;
	private LocalDateTime timestamp;
	
	public CustomErrorResponse() {
	}

	
	public CustomErrorResponse(int statusCode, String message) {
		super();
		this.statusCode = statusCode;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}


	public int getStatusCode() {
		return statusCode;
	}


	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
