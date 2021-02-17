package com.cg.citipark.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;


import com.cg.citipark.exceptions.NoSuchParkingSlotException;
import com.cg.citipark.exceptions.ParkingSlotNotAvailableException;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;
import com.cg.citipark.models.ParkingSlots;

public interface ParkingService {
	public boolean checkAvailability(LocalDate date, String time) throws ParkingSlotNotAvailableException, SQLException;
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException, SQLException;
	public boolean cancelParkingSlotBooking(long parkingSlotId) throws NoSuchParkingSlotException, SQLException;
	
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise);
	public List<ParkingSlots> getAllParkingSlotsByFloor(ParkingFloor parkingFloor);
	public ParkingSlots getParkingSlotsById(long parkingSlotId) throws NoSuchParkingSlotException, SQLException;
	
}
