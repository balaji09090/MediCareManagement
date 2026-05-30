	package com.example.demo.controller;
	
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;
	
	import com.example.demo.exception.InvalidAge;
	import com.example.demo.exception.InvalidDoB;
	import com.example.demo.exception.InvalidGender;
	import com.example.demo.exception.InvalidId;
	import com.example.demo.exception.InvalidMobileNumber;
	import com.example.demo.exception.InvalidName;
	
	@RestControllerAdvice
	public class GlobalExceptionHandler {
	
	    @ExceptionHandler(InvalidMobileNumber.class)
	    public ResponseEntity<?> InvalidMobileNumber(InvalidMobileNumber e) {
	        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
	                .body(e.getMessage());
	    }
	
	    @ExceptionHandler(InvalidAge.class)
	    public ResponseEntity<?> InvalidAge(InvalidAge e) {
	        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
	                .body(e.getMessage());
	    }
	
	    @ExceptionHandler(InvalidName.class)
	    public ResponseEntity<?> InvalidName(InvalidName e) {
	        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
	                .body(e.getMessage());
	    }
	
	    @ExceptionHandler(InvalidGender.class)
	    public ResponseEntity<?> InvalidGender(InvalidGender e) {
	        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
	                .body(e.getMessage());
	    }
	
	    @ExceptionHandler(InvalidId.class)
	    public ResponseEntity<?> InvalidId(InvalidId e) {
	        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
	                .body(e.getMessage());
	    }
	
	    @ExceptionHandler(InvalidDoB.class)
	    public ResponseEntity<?> InvalidDoB(InvalidDoB e) {
	        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
	                .body(e.getMessage());
	    }
	}