package com.masai.exception;

public class PostNotFoundException extends RuntimeException{
	public PostNotFoundException() {
		
	}
	public PostNotFoundException(String message) {
		super(message);
	}
}
