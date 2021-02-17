package com.cg.citipark.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "parkingfloors")
public class ParkingFloor {
	// should be auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parkingFloorId;
	
	@OneToOne
	@JoinColumn(name = "parkingpremise_id")
	private ParkingPremise parkingPremise;
	private String floorNumber;
	private int numberOfParkingSlots;
	
	// Constructors, Getter & Setter method
	/**
	 * Default constructor for parking floor
	 */
	public ParkingFloor() {
	}

	/**
	 * Parameterized constructor for parking floor
	 * @param parkingFloorId
	 * @param parkingPremise
	 * @param floorNumber
	 * @param numberOfParkingSlots
	 */
	public ParkingFloor(int parkingFloorId, ParkingPremise parkingPremise, String floorNumber,
			int numberOfParkingSlots) {
		super();
		this.parkingFloorId = parkingFloorId;
		this.parkingPremise = parkingPremise;
		this.floorNumber = floorNumber;
		this.numberOfParkingSlots = numberOfParkingSlots;
	}

	public int getParkingFloorId() {
		return parkingFloorId;
	}

	public void setParkingFloorId(int parkingFloorId) {
		this.parkingFloorId = parkingFloorId;
	}

	public ParkingPremise getParkingPremise() {
		return parkingPremise;
	}

	public void setParkingPremise(ParkingPremise parkingPremise) {
		this.parkingPremise = parkingPremise;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public int getNumberOfParkingSlots() {
		return numberOfParkingSlots;
	}

	public void setNumberOfParkingSlots(int numberOfParkingSlots) {
		this.numberOfParkingSlots = numberOfParkingSlots;
	}

	@Override
	public String toString() {
		return "ParkingFloor [parkingFloorId=" + parkingFloorId + ", parkingPremise=" + parkingPremise
				+ ", floorNumber=" + floorNumber + ", numberOfParkingSlots=" + numberOfParkingSlots + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((floorNumber == null) ? 0 : floorNumber.hashCode());
		result = prime * result + numberOfParkingSlots;
		result = prime * result + parkingFloorId;
		result = prime * result + ((parkingPremise == null) ? 0 : parkingPremise.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ParkingFloor other = (ParkingFloor) obj;
		if (floorNumber == null) {
			if (other.floorNumber != null)
				return false;
		} else if (!floorNumber.equals(other.floorNumber))
			return false;
		if (numberOfParkingSlots != other.numberOfParkingSlots)
			return false;
		if (parkingFloorId != other.parkingFloorId)
			return false;
		if (parkingPremise == null) {
			if (other.parkingPremise != null)
				return false;
		} else if (!parkingPremise.equals(other.parkingPremise))
			return false;
		return true;
	}
	
}
