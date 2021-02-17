package com.cg.citipark.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parkingpremises")
public class ParkingPremise {
	// should be auto-generated
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int parkingPremiseId;
	private String parkingPremiseName;
	
	@OneToOne
	@JoinColumn (name = "address_id")
	private Address premiseAddress;
	private int numberOfParkingFloors;
	
	// Constructors, Getter & Setter method
	/**
	 * Default constructor for parking premise
	 */
	public ParkingPremise() {
	}

	/**
	 * Parameterized constructor for parking premise
	 * @param parkingPremiseId
	 * @param parkingPremiseName
	 * @param premiseAddress
	 * @param numberOfParkingFloors
	 */
	public ParkingPremise(int parkingPremiseId, String parkingPremiseName, Address premiseAddress,
			int numberOfParkingFloors) {
		super();
		this.parkingPremiseId = parkingPremiseId;
		this.parkingPremiseName = parkingPremiseName;
		this.premiseAddress = premiseAddress;
		this.numberOfParkingFloors = numberOfParkingFloors;
	}

	public int getParkingPremiseId() {
		return parkingPremiseId;
	}

	public void setParkingPremiseId(int parkingPremiseId) {
		this.parkingPremiseId = parkingPremiseId;
	}

	public String getParkingPremiseName() {
		return parkingPremiseName;
	}

	public void setParkingPremiseName(String parkingPremiseName) {
		this.parkingPremiseName = parkingPremiseName;
	}

	public Address getPremiseAddress() {
		return premiseAddress;
	}

	public void setPremiseAddress(Address premiseAddress) {
		this.premiseAddress = premiseAddress;
	}

	public int getNumberOfParkingFloors() {
		return numberOfParkingFloors;
	}

	public void setNumberOfParkingFloors(int numberOfParkingFloors) {
		this.numberOfParkingFloors = numberOfParkingFloors;
	}

	
	@Override
	public String toString() {
		return "ParkingPremise [parkingPremiseId=" + parkingPremiseId + ", parkingPremiseName=" + parkingPremiseName
				+ ", premiseAddress=" + premiseAddress + ", numberOfParkingFloors=" + numberOfParkingFloors + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberOfParkingFloors;
		result = prime * result + parkingPremiseId;
		result = prime * result + ((parkingPremiseName == null) ? 0 : parkingPremiseName.hashCode());
		result = prime * result + ((premiseAddress == null) ? 0 : premiseAddress.hashCode());
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
		ParkingPremise other = (ParkingPremise) obj;
		if (numberOfParkingFloors != other.numberOfParkingFloors)
			return false;
		if (parkingPremiseId != other.parkingPremiseId)
			return false;
		if (parkingPremiseName == null) {
			if (other.parkingPremiseName != null)
				return false;
		} else if (!parkingPremiseName.equals(other.parkingPremiseName))
			return false;
		if (premiseAddress == null) {
			if (other.premiseAddress != null)
				return false;
		} else if (!premiseAddress.equals(other.premiseAddress))
			return false;
		return true;
	}
	
}
