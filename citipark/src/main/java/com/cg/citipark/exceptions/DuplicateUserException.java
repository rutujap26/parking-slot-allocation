package com.cg.citipark.exceptions;

public class DuplicateUserException extends Exception {
	private static final long serialVersionUID = 1L;
	public DuplicateUserException(){
		
	}
	public DuplicateUserException(String message) {
		super(message);
	}
}
