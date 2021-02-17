package com.cg.citipark.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VehiclesTable")
public class Vehicle {
	// should be auto-generated
	@Id
	
	private long vehicleId;
	private String vehicleNumber;
	private String vehicleCompany;
	private String vehicleModel;
	private String vehicleType;
//	private User owner;
	
	
	public Vehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
public Vehicle(long vehicleId, String vehicleNumber, String vehicleCompany, String vehicleModel,
		String vehicleType) {
	super();
	this.vehicleId = vehicleId;
	this.vehicleNumber = vehicleNumber;
	this.vehicleCompany = vehicleCompany;
	this.vehicleModel = vehicleModel;
	this.vehicleType = vehicleType;
}

//	public Vehicle(long vehicleId,String vehicleNumber, String vehicleCompany,String vehicleModel) {
//		super();
//		this.vehicleId = vehicleId;
//		this.vehicleNumber = vehicleNumber;
//		this.vehicleCompany = vehicleCompany;
//		this.vehicleModel = vehicleModel;
//	}
	public long getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(long vehicleId) {
		this.vehicleId = vehicleId;
	}
	
	public String getVehicleType() {
		return vehicleType;
	}

	
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getVehicleCompany() {
		return vehicleCompany;
	}
	public void setVehicleCompany(String vehicleCompany) {
		this.vehicleCompany = vehicleCompany;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	public void setVehicleModel(String vehicleModel) {
		this.vehicleModel = vehicleModel;
	}
//	public User getOwner() {
//		return owner;
//	}
//	public void setOwner(User owner) {
//		this.owner = owner;
//	}

	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", vehicleCompany="
				+ vehicleCompany + ", vehicleModel=" + vehicleModel + ", vehicleType=" + vehicleType + "]";
	}

	
	
	
//	@Override
//	public String toString() {
//		return "Vehicle [vehicleId=" + vehicleId + ", vehicleNumber=" + vehicleNumber + ", vehicleCompany="
//				+ vehicleCompany + ", vehicleModel=" + vehicleModel + "]";
//	}
//	
	
	
	// Constructors, Getter & Setter method
	
}
