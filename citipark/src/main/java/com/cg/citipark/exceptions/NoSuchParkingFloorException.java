package com.cg.citipark.exceptions;

public class NoSuchParkingFloorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoSuchParkingFloorException() {
	}
	
	public NoSuchParkingFloorException(String message) {
		super(message);
	}
}
