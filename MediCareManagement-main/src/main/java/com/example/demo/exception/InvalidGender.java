package com.example.demo.exception;

public class InvalidGender extends RuntimeException {

	public InvalidGender (String message) {
		super(message);
	}
}
