package com.employee_api.employeemanager.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleNotFound(ResourceNotFoundException ex){
		CustomErrorResponse error = new CustomErrorResponse(
				HttpStatus.NOT_FOUND.value(), ex.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//manejo de excepciones para bad request
		@ExceptionHandler(BadRequestException.class)
		public ResponseEntity<CustomErrorResponse> handleBadRequest(BadRequestException ex){
			CustomErrorResponse error = new CustomErrorResponse(
					HttpStatus.BAD_REQUEST.value(), ex.getMessage()
	 				);
			return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		}
		
		//manejo de errores de validacion
		@ExceptionHandler(MethodArgumentNotValidException.class)
		public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex){
			Map<String, String> errors = new HashMap<>();
			ex.getBindingResult().getFieldErrors().forEach(field ->
			errors.put(field.getField(), field.getDefaultMessage())
			);
			return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
		}
		
		//Manejo general para cualquier otra excepcion
		@ExceptionHandler(Exception.class)
		public ResponseEntity<CustomErrorResponse> handleGeneral(Exception ex){
			CustomErrorResponse error = new CustomErrorResponse(
					HttpStatus.INTERNAL_SERVER_ERROR.value(), "An unexpected error ocurred."
					);
			return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}

}
