package com.cg.citipark.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.citipark.daos.ParkingDAO;
import com.cg.citipark.daos.ParkingDAOImpl;
import com.cg.citipark.exceptions.NoSuchParkingSlotException;
import com.cg.citipark.exceptions.ParkingSlotNotAvailableException;
import com.cg.citipark.models.ParkingSlots;
import com.cg.citipark.services.ParkingService;
import com.cg.citipark.services.ParkingServiceImpl;



public class ParkingServiceTest {
	private static ParkingService service;
	private static ParkingDAO dao;
	ParkingSlots parkingSlots1,parkingSlots2;
	
	
	@BeforeClass
	public static  void setUpTestEnv() {
		dao= new ParkingDAOImpl();
		service = new ParkingServiceImpl();

	}
	@Before 
	public void setUpTestMockData() throws SQLException, ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		 parkingSlots1 = new ParkingSlots(  LocalDate.parse("06/02/2021", formatter),
				"19:00", LocalDate.parse("2021-02-04"), 3);
		 parkingSlots1=dao.createParkingSlots(parkingSlots1);
		 parkingSlots2 = new ParkingSlots(  LocalDate.parse("05/02/2021", formatter),
					"19:00", LocalDate.parse("2021-02-04"), 3);
			 parkingSlots2=dao.createParkingSlots(parkingSlots2);
			 
	}


	@Test
	public void testGetParkingDetaailsForValidId() throws NoSuchParkingSlotException, SQLException {
		ParkingSlots parkingActual =service.getParkingSlotsById(parkingSlots1.getParkingSlotId());
		assertNotEquals(parkingSlots1,parkingActual);
		}
	
	@Test
	public void testGetCheckAvailability() throws NoSuchParkingSlotException, SQLException, ParkingSlotNotAvailableException, ParseException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		boolean parkingActual =service.checkAvailability(LocalDate.parse("06/02/2021", formatter), "19:00");
		assertEquals(parkingActual, false);
	}
	@Test
	public void bookParkingSlot() throws ParkingSlotNotAvailableException, SQLException  {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		
		ParkingSlots parkingSlots3 = new ParkingSlots(  LocalDate.parse("07/02/2021", formatter),
				"19:00", LocalDate.parse("2021-02-04"), 3);
		boolean parkingActual1 =service.bookParkingSlot(parkingSlots3);
		assertTrue(parkingActual1);
		
	}
	
	
	@After 
	public void tearDownTestMockData() throws SQLException {
		dao.cancelParkingSlotBooking(parkingSlots1.getParkingSlotId());
		dao.cancelParkingSlotBooking(parkingSlots2.getParkingSlotId());
		
	}

}
