package com.cg.citipark.daos;

import java.util.List;

import com.cg.citipark.models.Admin;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;

public interface AdminDAO {

	/**
	 * To check login credentials are valid or invalid.
	 * @param login
	 * @return
	 */
	public Admin login(Admin login);

	// Parking Premise
	/**
	 * To create parkingPremise.
	 * @param parkingPremise
	 * @return 
	 */
	public boolean createParkingPremise(ParkingPremise parkingPremise);
	
	/**
	 * To read Parking premise by using parking premise id.
	 * @param parkingPremiseId
	 * @return parking premise of given id.
	 */
	public ParkingPremise readParkingPremiseById(int parkingPremiseId);
	
	/**
	 * To read parking premises by using name of parking premise.
	 * @param premiseName
	 * @return list of parking premises with same name.
	 */
	public List<ParkingPremise> readParkingPremiseByName(String premiseName);
	
	/**
	 * To read all parking premises.
	 * @return list of all parking premises.
	 */
	public List<ParkingPremise> readAllParkingPremises();
	
	/**
	 * To update parking premise using new parking premise.
	 * @param parkingPremise
	 * @return updated parking premise.
	 */
	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise);
	
	/**
	 * To delete parking premise using parking premise id.
	 * @param parkingPremiseId
	 * @return
	 */
	public boolean deleteParkingPremise(int parkingPremiseId);

	// Parking Floor
	/**
	 * To create parking floor.
	 * @param parkingFloor
	 * @return
	 */
	public boolean createParkingFloor(ParkingFloor parkingFloor);
	
	/**
	 * To read parking floor by using parking floor id.
	 * @param parkingFloorId
	 * @return parking floor of given id.
	 */
	public ParkingFloor readParkingFloorById(int parkingFloorId);
	
	/**
	 * To read parking floor by using  floor number.
	 * @param floorNumber
	 * @return list of parking floors.
	 */
	public List<ParkingFloor> readParkingFloorByNumber(String floorNumber);
	
	/**
	 * To read all parking floors.
	 * @return list of all parking floors.
	 */
	public List<ParkingFloor> readAllParkingFloors();
	
	/**
	 * To update parking floor using new parking floor.
	 * @param parkingFloor
	 * @return updated parking floor.
	 */
	public ParkingFloor updateParkingCapacity(ParkingFloor parkingFloor);
	
	/**
	 * To delete parking floor by id.
	 * @param parkingFloorId
	 * @return
	 */
	public boolean deleteParkingFloor(int parkingFloorId);
}
