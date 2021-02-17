package com.cg.citipark.daos;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cg.citipark.exceptions.ParkingSlotNotAvailableException;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;
import com.cg.citipark.models.ParkingSlots;
import com.cg.citipark.models.Vehicle;

public interface ParkingDAO {
	public boolean checkAvailability(LocalDate date, String time) throws SQLException;
	public boolean bookParkingSlot(ParkingSlots slot) throws SQLException, ParkingSlotNotAvailableException;
	public boolean cancelParkingSlotBooking(long id) throws SQLException;
	
	public List<ParkingSlots> readAllParkingSlotsByPremise(ParkingPremise parkingPremise);
	public List<ParkingSlots> readAllParkingSlotsByFloor(ParkingFloor parkingFloor);
	public ParkingSlots readParkingSlotsById(long parkingSlotId) throws SQLException;
	
	
	public ParkingSlots createParkingSlots(ParkingSlots parkingslot) throws SQLException;
	

}
