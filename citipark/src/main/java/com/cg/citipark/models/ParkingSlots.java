package com.cg.citipark.models;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="parkingslots")
public class ParkingSlots {
	public ParkingSlots() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long parkingSlotId;
	//private ParkingFloor parkingFloor;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vehicleid")
	private Vehicle vehicle;
	
	private LocalDate parkingDate;
	private String parkingTime;
	private LocalDate bookingDate;
	private int parkingDuration;
	//@OneToOne(cascade = CascadeType.ALL)
	//private Payment payment;
	
	public ParkingSlots(long parkingSlotId,  Vehicle vehicle, LocalDate parkingDate,
			String parkingTime, LocalDate bookingDate, int parkingDuration) {
		super();
		this.parkingSlotId = parkingSlotId;
		//this.parkingFloor = parkingFloor;
		//this.vehicle = vehicle;
		this.parkingDate = parkingDate;
		this.parkingTime = parkingTime;
		this.bookingDate = bookingDate;
		this.parkingDuration = parkingDuration;
		//this.payment = payment;
	}
	public ParkingSlots(   LocalDate parkingDate,
			String parkingTime, LocalDate bookingDate, int parkingDuration) {
		super();
		//this.parkingSlotId = parkingSlotId;
		//this.parkingFloor = parkingFloor;
		//this.vehicle = vehicle;
		this.parkingDate = parkingDate;
		this.parkingTime = parkingTime;
		this.bookingDate = bookingDate;
		this.parkingDuration = parkingDuration;
		//this.payment = payment;
	}
	
	
	public long getParkingSlotId() {
		return parkingSlotId;
	}
	public void setParkingSlotId(long parkingSlotId) {
		this.parkingSlotId = parkingSlotId;
	}
	/*public ParkingFloor getParkingFloor() {
		return parkingFloor;
	}
	public void setParkingFloor(ParkingFloor parkingFloor) {
		this.parkingFloor = parkingFloor;
	}*/
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public LocalDate getParkingDate() {
		return parkingDate;
	}
	public void setParkingDate(LocalDate parkingDate) {
		this.parkingDate = parkingDate;
	}
	public String getParkingTime() {
		return parkingTime;
	}
	public void setParkingTime(String parkingTime) {
		this.parkingTime = parkingTime;
	}
	public LocalDate  getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(LocalDate  bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getParkingDuration() {
		return parkingDuration;
	}
	public void setParkingDuration(int parkingDuration) {
		this.parkingDuration = parkingDuration;
	}
	/*public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}*/
	@Override
	public String toString() {
		return "ParkingSlots [parkingSlotId=" + parkingSlotId + ", vehicle=" + vehicle + ", parkingDate=" + parkingDate
				+ ", parkingTime=" + parkingTime + ", bookingDate=" + bookingDate + ", parkingDuration="
				+ parkingDuration + "]";
	}
	
	
	// Constructors, Getter & Setter method
}
