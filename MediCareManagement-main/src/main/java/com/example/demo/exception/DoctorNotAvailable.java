package com.example.demo.exception;

public class DoctorNotAvailable extends RuntimeException {

	public DoctorNotAvailable (String message) {
		super(message);
	}
}
