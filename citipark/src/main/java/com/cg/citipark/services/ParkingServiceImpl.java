package com.cg.citipark.services;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.cg.citipark.daos.ParkingDAO;
import com.cg.citipark.daos.ParkingDAOImpl;
import com.cg.citipark.exceptions.NoSuchParkingSlotException;
import com.cg.citipark.exceptions.ParkingSlotNotAvailableException;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;
import com.cg.citipark.models.ParkingSlots;

public class ParkingServiceImpl implements ParkingService {
	ParkingSlots parkingslot = new ParkingSlots();
	ParkingDAO dao = new ParkingDAOImpl();
	@Override
	public boolean checkAvailability(LocalDate date, String time) throws ParkingSlotNotAvailableException, SQLException {
		// TODO Auto-generated method stub
		return dao.checkAvailability(date, time);
	}

	@Override
	public boolean bookParkingSlot(ParkingSlots slot) throws ParkingSlotNotAvailableException, SQLException {
		// TODO Auto-generated method stub
		return dao.bookParkingSlot(slot);
	}

	@Override
	public boolean cancelParkingSlotBooking(long parkingSlotId) throws NoSuchParkingSlotException, SQLException {
		boolean check = dao.cancelParkingSlotBooking(parkingSlotId);
		if(check==true)
		{
			return true;
		}
		return false;
	}

	@Override
	public List<ParkingSlots> getAllParkingSlotsByPremise(ParkingPremise parkingPremise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingSlots> getAllParkingSlotsByFloor(ParkingFloor parkingFloor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingSlots getParkingSlotsById(long parkingSlotId) throws NoSuchParkingSlotException, SQLException {
		return dao.readParkingSlotsById(parkingSlotId);
	}

}
