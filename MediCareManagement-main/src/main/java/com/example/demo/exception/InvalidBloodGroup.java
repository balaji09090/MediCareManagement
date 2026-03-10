package com.example.demo.exception;

public class InvalidBloodGroup extends RuntimeException {

	public InvalidBloodGroup (String message) {
		super(message);
	}
}
