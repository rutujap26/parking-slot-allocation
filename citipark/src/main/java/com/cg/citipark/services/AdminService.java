package com.cg.citipark.services;

import java.util.List;

import com.cg.citipark.exceptions.DuplicateParkingFloorException;
import com.cg.citipark.exceptions.DuplicateParkingPremiseException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchParkingFloorException;
import com.cg.citipark.exceptions.NoSuchParkingPremiseException;
import com.cg.citipark.models.Admin;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;


public interface AdminService {

	/**
	 * To check login credentials are valid or not.
	 * @param login
	 * @return true if login credentials are valid.
	 * @throws InvalidLoginCredentialException
	 */
	public boolean login(Admin login) throws InvalidLoginCredentialException;
	
	// Parking Premise
	/**
	 * To add parking premise in database.
	 * @param parkingPremise
	 * @return true, if parking premise added successfully.
	 * @throws DuplicateParkingPremiseException for duplicate entry.
	 */
	public boolean addParkingPremise(ParkingPremise parkingPremise) throws DuplicateParkingPremiseException;
	
	/**
	 * To get/find parking premise by using parking premise id.
	 * @param parkingPremiseId
	 * @return parking premise with given id.
	 * @throws NoSuchParkingPremiseException for id which is not present in database.
	 */
	public ParkingPremise getParkingPremiseById(int parkingPremiseId) throws NoSuchParkingPremiseException;
	
	/**
	 * To get/find parking premises using parking premise name.
	 * @param premiseName
	 * @return list of parking premises with same name.
	 * @throws NoSuchParkingPremiseException for name which is not present in database.
	 */
	public List<ParkingPremise> getParkingPremiseByName(String premiseName) throws NoSuchParkingPremiseException;
	
	/**
	 * To get/find all parking premises.
	 * @return list of all parking premises.
	 */
	public List<ParkingPremise> getAllParkingPremises();
	
	/**
	 * To modify parking premise with new parking premise.
	 * @param parkingPremise
	 * @return modified parking premise.
	 */
	public ParkingPremise modifyParkingPremise(ParkingPremise parkingPremise);
	
	/**
	 * To remove parking premise of given parking premise id.
	 * @param parkingPremiseId
	 * @return true if parking premise removed successfully.
	 * @throws NoSuchParkingPremiseException id which is not present in database. 
	 */
	public boolean removeParkingPremise(int parkingPremiseId) throws NoSuchParkingPremiseException;
	
	// Parking Floor
	/**
	 * To add parking floor in database.
	 * @param parkingFloor
	 * @return true if parking floor added successfully.
	 * @throws DuplicateParkingFloorException for duplicate entry.
	 */
	public boolean addParkingFloor(ParkingFloor parkingFloor) throws DuplicateParkingFloorException;
	
	/**
	 * To get/find parking floor by using parking floor id.
	 * @param parkingFloorId
	 * @return parking floor of given id.
	 * @throws NoSuchParkingFloorException for id which is not present in database.
	 */
	public ParkingFloor getParkingFloorById(int parkingFloorId) throws NoSuchParkingFloorException;
	
	/**
	 * To get/find parking floor using given floor number.
	 * @param floorNumber
	 * @return list of parking floors with same floor number.
	 * @throws NoSuchParkingFloorException for floor number which is not present in database.
	 */
	public List<ParkingFloor> getParkingFloorByNumber(String floorNumber) throws NoSuchParkingFloorException;
	
	/**
	 * To get/find all parking floors.
	 * @return list of all parking floors.
	 */
	public List<ParkingFloor> getAllParkingFloors();
	
	/**
	 * To modify parking floor using new parking floor.
	 * @param parkingFloor
	 * @return modified parking floor.
	 */
	public ParkingFloor modifyParkingCapacity(ParkingFloor parkingFloor);
	
	/**
	 * To remove parking floor of given id.
	 * @param parkingFloorId
	 * @return true if parking floor removed successfully.
	 * @throws NoSuchParkingFloorException for id which is not present in database.
	 */
	public boolean removeParkingFloor(int parkingFloorId) throws NoSuchParkingFloorException;
}
