package com.example.demo.exception;

public class InvalidAppointmentStatus extends RuntimeException {

	public InvalidAppointmentStatus (String message) {
		super(message);
	}
}
