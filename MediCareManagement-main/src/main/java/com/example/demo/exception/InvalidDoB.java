package com.example.demo.exception;

public class InvalidDoB extends RuntimeException{

	public InvalidDoB (String message) {
		super(message);
	}
}
