package com.cg.citipark.tests;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.citipark.daos.AdminDAO;
import com.cg.citipark.daos.AdminDAOImpl;
import com.cg.citipark.exceptions.DuplicateParkingFloorException;
import com.cg.citipark.exceptions.DuplicateParkingPremiseException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchParkingFloorException;
import com.cg.citipark.exceptions.NoSuchParkingPremiseException;
import com.cg.citipark.models.Address;
import com.cg.citipark.models.Admin;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;
import com.cg.citipark.services.AdminService;
import com.cg.citipark.services.AdminServiceImpl;

public class AdminServiceImplTest {
	private static AdminService service;
	private static AdminDAO dao;
	private Address address1,address2,address3;
	private ParkingPremise premise1,premise2,premise3;
	private ParkingFloor floor1, floor2, floor3;

	@BeforeClass
	public static void setUpBeforeClass(){
		dao = new AdminDAOImpl();
		service = new AdminServiceImpl();
		
	}

	
	@Before
	public void setUp() {
		address1 = new Address(8,"Mumbai","Maharashtra","413416");
		address2 = new Address(19,"Thane","Rajsthan","423232");
		address3 = new Address(29,"Pune","Maharashtra","411232");
		premise1 = new ParkingPremise(9,"parking11",address1,5);
		premise2 = new ParkingPremise(20,"parking23",address2, 3);
		premise3 = new ParkingPremise(30,"parking55",address3,2);
		floor1 = new ParkingFloor(10,premise1,"p1",4);
		floor2 = new ParkingFloor(35,premise2,"p5",4);
		floor3 = new ParkingFloor(31,premise3,"p6",3);
		dao.createParkingPremise(premise1);
		dao.createParkingPremise(premise2);
		dao.createParkingPremise(premise3);
		dao.createParkingFloor(floor1);
		dao.createParkingFloor(floor2);
		dao.createParkingFloor(floor3);
	}


	@Test (expected = InvalidLoginCredentialException.class)
	public void testLoginForInValidCredentials() throws InvalidLoginCredentialException{
		Admin admin = new Admin("rutu@gmail.com","rutu");
		service.login(admin);
	}
	
	@Test
	public void testLoginForValidCredentials() throws InvalidLoginCredentialException {
		Admin admin = new Admin("rutuja@gmail.com","rutuja");
		boolean result = service.login(admin);
		assertEquals(true, result);
	}

	@Test (expected = DuplicateParkingPremiseException.class)
	public void testAddParkingPremiseForDuplicateParkingPremise() throws DuplicateParkingPremiseException{
		service.addParkingPremise(premise2);
	}

	@Test
	public void testGetParkingPremiseByIdForValidId() throws NoSuchParkingPremiseException{
		ParkingPremise result = service.getParkingPremiseById(premise2.getParkingPremiseId());
		assertEquals(premise2.toString(), result.toString());
	}
	
	@Test (expected = NoSuchParkingPremiseException.class)
	public void testGetParkingPremiseByIdForInvalidId() throws NoSuchParkingPremiseException{
		service.getParkingPremiseById(555);
	}

	@Test
	public void testGetParkingPremiseByNameForValidName() throws NoSuchParkingPremiseException {
		List<ParkingPremise> result = service.getParkingPremiseByName(premise1.getParkingPremiseName());
		assertEquals(premise1, result.get(0));
	}
	
	@Test (expected = NoSuchParkingPremiseException.class)
	public void testGetParkingPremiseByNameForInValidName() throws NoSuchParkingPremiseException {
		service.getParkingPremiseByName("park");
	}

	@Test
	public void testGetAllParkingPremises(){
		List<ParkingPremise> result = service.getAllParkingPremises();
		assertEquals(premise1, result.get(0));
	}

	@Test
	public void testModifyParkingPremise() {
		ParkingPremise result = service.modifyParkingPremise(premise3);
		assertEquals(premise3, result);
	}

	@Test (expected = NoSuchParkingPremiseException.class)
	public void testRemoveParkingPremise() throws NoSuchParkingPremiseException {
		service.removeParkingPremise(2);
	}

	@Test(expected = DuplicateParkingFloorException.class)
	public void testAddParkingFloor() throws DuplicateParkingFloorException {
		service.addParkingFloor(floor1);
	}

	@Test
	public void testGetParkingFloorByIdForValidId() throws NoSuchParkingFloorException {
		ParkingFloor result = service.getParkingFloorById(floor1.getParkingFloorId());
		assertEquals(floor1, result);
	}
	
	@Test (expected = NoSuchParkingFloorException.class)
	public void testGetParkingFloorByIdForInvalidId() throws NoSuchParkingFloorException {
		service.getParkingFloorById(555);
	}

	@Test
	public void testGetParkingFloorByNumberForValidNumber() throws NoSuchParkingFloorException{
		List<ParkingFloor> result = service.getParkingFloorByNumber(floor2.getFloorNumber());
		assertEquals(floor2, result.get(0));
	}
	
	@Test (expected = NoSuchParkingFloorException.class)
	public void testGetParkingFloorByNumberForInvalidNumber() throws NoSuchParkingFloorException{
		service.getParkingFloorByNumber("pppp");
	}

	@Test
	public void testGetAllParkingFloors() {
		List<ParkingFloor> result = service.getAllParkingFloors();
		assertEquals(floor1, result.get(0));
	}

	@Test
	public void testModifyParkingCapacity() {
		ParkingFloor result = service.modifyParkingCapacity(floor3);
		assertEquals(floor3, result);
	}

	@Test (expected = NoSuchParkingFloorException.class)
	public void testRemoveParkingFloor() throws NoSuchParkingFloorException{
		service.removeParkingFloor(39);
	}
	
	@After
	public void tearDownMockData() {
		dao.deleteParkingFloor(floor1.getParkingFloorId());
		dao.deleteParkingFloor(floor2.getParkingFloorId());
		dao.deleteParkingFloor(floor3.getParkingFloorId());
		dao.deleteParkingPremise(premise1.getParkingPremiseId());
		dao.deleteParkingPremise(premise2.getParkingPremiseId());
		dao.deleteParkingPremise(premise3.getParkingPremiseId());
	}
	
	@AfterClass
	public static void tearDownAfterClass(){
		dao=null;
		service=null;
	}
}
