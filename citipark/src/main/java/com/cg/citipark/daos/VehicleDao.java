package com.cg.citipark.daos;

import java.sql.SQLException;
import java.util.List;

import com.cg.citipark.models.Vehicle;

public interface VehicleDao {

	public boolean createUsersVehicle(Vehicle vehicle) throws SQLException;
	public Vehicle readVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws SQLException;
	public List<Vehicle> readAllVehiclesByUserId(int ownerId);
	public List<Vehicle> readAllVehicles();
	public boolean deleteVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws SQLException;
	public Vehicle updateVehicle(Vehicle vehicle);
	public Vehicle getVehicleById(long id);
}
