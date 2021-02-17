package com.cg.citipark.exceptions;

public class DuplicateParkingPremiseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateParkingPremiseException() {
	}
	
	public DuplicateParkingPremiseException(String message) {
		super(message);
	}
}
