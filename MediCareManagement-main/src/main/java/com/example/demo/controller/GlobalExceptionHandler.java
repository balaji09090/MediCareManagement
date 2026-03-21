package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.InvalidAge;
import com.example.demo.exception.InvalidMobileNumber;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(InvalidMobileNumber.class)
	public ResponseEntity<?> InvalidMobileNumber(InvalidMobileNumber e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	@ExceptionHandler(InvalidAge.class)
	public ResponseEntity<?> InvalidAge(InvalidAge e) {
		return ResponseEntity.status(HttpStatus.UNPROCESSABLE_CONTENT).body(e.getMessage());
	}
	
	
	
}
