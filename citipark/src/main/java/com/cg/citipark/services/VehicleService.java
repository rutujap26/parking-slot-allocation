package com.cg.citipark.services;

import java.sql.SQLException;
import java.util.List;

import com.cg.citipark.exceptions.*;

import com.cg.citipark.exceptions.DuplicateVehicleException;
import com.cg.citipark.exceptions.NoSuchVehicleException;
import com.cg.citipark.models.Vehicle;


public interface VehicleService {
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException, SQLException;
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws NoSuchVehicleException, SQLException; // need to change int to long, vehicleId to userId
	public List<Vehicle> findAllVehiclesByUserId(int ownerId);
	public List<Vehicle> findAllVehicles();
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws NoSuchVehicleException, SQLException;
	public Vehicle modifyVehicle(Vehicle vehicle);
	public Vehicle findByVehicleId(long id);
}
