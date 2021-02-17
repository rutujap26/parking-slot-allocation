package com.cg.citipark.exceptions;

public class NoSuchParkingPremiseException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchParkingPremiseException() {
	}
	
	public NoSuchParkingPremiseException(String message) {
		super(message);
	}
}
