package com.cg.citipark.exceptions;

public class NoSuchUserException extends Exception {
	private static final long serialVersionUID = 1L;
    public NoSuchUserException() {	
	}
	public NoSuchUserException(String message) {
		super(message);
	}
}
