package com.cg.citipark.exceptions;

public class InvalidLoginCredentialException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidLoginCredentialException() {
	}
	
	public InvalidLoginCredentialException(String message) {
		super(message);
	}
}
