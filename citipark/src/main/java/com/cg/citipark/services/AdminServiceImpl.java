package com.cg.citipark.services;

import java.util.List;

import com.cg.citipark.daos.AdminDAO;
import com.cg.citipark.daos.AdminDAOImpl;
import com.cg.citipark.exceptions.DuplicateParkingFloorException;
import com.cg.citipark.exceptions.DuplicateParkingPremiseException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchParkingFloorException;
import com.cg.citipark.exceptions.NoSuchParkingPremiseException;
import com.cg.citipark.models.Admin;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;

public class AdminServiceImpl implements AdminService {
	AdminDAO dao = new AdminDAOImpl();

	@Override
	public boolean login(Admin login) throws InvalidLoginCredentialException {
		Admin admin = dao.login(login);
		if(admin == null)
			throw new InvalidLoginCredentialException("Login Failed");
		else {
			if(login.getPassword().equals(admin.getPassword()))
				System.out.println("Success!");
			else
				throw new InvalidLoginCredentialException("Login Failed");
		}
		return true;
	}

	@Override
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException {
		boolean status = dao.createParkingPremise(parkingPremise);
		if(status==false)
			throw new DuplicateParkingPremiseException("Duplicate Parking Premise");
		else 
			return true;
	}

	@Override
	public ParkingPremise getParkingPremiseById(int parkingPremiseId) throws NoSuchParkingPremiseException {
		ParkingPremise premise = dao.readParkingPremiseById(parkingPremiseId);
		if(premise==null)
			throw new NoSuchParkingPremiseException("No Such Parking Premise Available");
		else
			return premise;
	}

	@Override
	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException {
		List<ParkingPremise> result = dao.readParkingPremiseByName(premiseName);
		System.out.println(result);
		if(result==null)
			throw new NoSuchParkingPremiseException("No Such Parking Premise Available");
		else
			return result;
	}

	@Override
	public List<ParkingPremise> getAllParkingPremises() {
		List<ParkingPremise> result = dao.readAllParkingPremises();
		return result;
	}

	@Override
	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise) {
		ParkingPremise result = dao.updateParkingPremise(parkingPremise);
		return result;
	}

	@Override
	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException {
		boolean result = dao.deleteParkingPremise(parkingPremiseId);
		if(result)
			return true;
		else
			throw new NoSuchParkingPremiseException("No Such Parking Premise Available");
	}

	@Override
	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException {
		boolean status = dao.createParkingFloor(parkingFloor);
		if(status==false) 
			throw new DuplicateParkingFloorException("Duplicate Parking Floor");
		else 
			return true;
	}

	@Override
	public ParkingFloor getParkingFloorById(int parkingFloorId) throws NoSuchParkingFloorException {
		ParkingFloor floor = dao.readParkingFloorById(parkingFloorId);
		if(floor==null)
			throw new NoSuchParkingFloorException("No Such Floor Available");
		else
			return floor;
	}

	@Override
	public List<ParkingFloor> getParkingFloorByNumber(String floorNumber) throws NoSuchParkingFloorException {
		List<ParkingFloor> result = dao.readParkingFloorByNumber(floorNumber);
		if(result==null)
			throw new NoSuchParkingFloorException("No Such Floor Available");
		else
			return result;
	}

	@Override
	public List<ParkingFloor> getAllParkingFloors() {
		List<ParkingFloor> result = dao.readAllParkingFloors();
		return result;
	}

	@Override
	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor) {
		ParkingFloor result = dao.updateParkingCapacity(parkingFloor);
		return result;
	}

	@Override
	public boolean removeParkingFloor(int parkingFloorId) throws NoSuchParkingFloorException {
		boolean status = dao.deleteParkingFloor(parkingFloorId);
		if(status==false)
			throw new NoSuchParkingFloorException("No Such Floor Available");
		return true;
	}

}
