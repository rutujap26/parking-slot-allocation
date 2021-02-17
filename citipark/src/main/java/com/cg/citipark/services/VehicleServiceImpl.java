package com.cg.citipark.services;

import java.sql.SQLException;
import java.util.List;

import com.cg.citipark.daos.VehicleDao;
import com.cg.citipark.daos.VehicleDaoImpl;
import com.cg.citipark.exceptions.DuplicateVehicleException;
import com.cg.citipark.exceptions.NoSuchVehicleException;
import com.cg.citipark.models.Vehicle;

public class VehicleServiceImpl implements VehicleService{

	Vehicle vehicle = new Vehicle();
	VehicleDao dao = new VehicleDaoImpl();
	
	@Override
	public boolean addUsersVehicle(Vehicle vehicle) throws DuplicateVehicleException, SQLException {
		return dao.createUsersVehicle(vehicle);
	}

	@Override
	public List<Vehicle> findAllVehiclesByUserId(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws NoSuchVehicleException, SQLException {
		boolean check = dao.deleteVehicleByVehicleNumber(vehicleNumber, vehicleId);
		if(check==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public Vehicle modifyVehicle(Vehicle vehicle) {
		return dao.updateVehicle(vehicle);
	}

	@Override
	public Vehicle findVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws NoSuchVehicleException, SQLException {
		return dao.readVehicleByVehicleNumber(vehicleNumber, vehicleId);
	}

	@Override
	public List<Vehicle> findAllVehicles() {
		return dao.readAllVehicles();
	}
	
	public Vehicle findByVehicleId(long id)
	{
		return dao.getVehicleById(id);
	}

}
