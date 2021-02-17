package com.cg.citipark.exceptions;

public class DuplicateParkingFloorException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateParkingFloorException() {
	}
	
	public DuplicateParkingFloorException(String message) {
		super(message);
	}
}
