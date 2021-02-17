package com.cg.citipark.tests;

import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import com.cg.citipark.daos.VehicleDao;
import com.cg.citipark.daos.VehicleDaoImpl;
import com.cg.citipark.exceptions.DuplicateVehicleException;
import com.cg.citipark.exceptions.NoSuchVehicleException;
import com.cg.citipark.models.Vehicle;
import com.cg.citipark.services.VehicleService;
import com.cg.citipark.services.VehicleServiceImpl;

public class VehicleServiceTest {
	private Vehicle vehicletest,vehicletest1;
	private static VehicleService vehicleService;
	private static VehicleDao vehicleDao;
	@BeforeClass
	public static void setUpTestEnv() {
		vehicleDao = new VehicleDaoImpl();
		vehicleService = new VehicleServiceImpl();
	}
	
	@Before
	public void settup()
	{
		
			
		vehicletest=new Vehicle(1001, "TN30","audi" , "petrol", "four wheeler");
		vehicletest1=new Vehicle(907, "TN50","activa" , "petrol", "two wheeler");
		
	}
			
	
	@Test
    public void testaddUsersVehicle() throws DuplicateVehicleException, SQLException {
		vehicleService.addUsersVehicle(vehicletest); 
    }
	
	
	@Test
	public void testremoveVehicleByVehicleNumber() throws NoSuchVehicleException, SQLException  {
	vehicleService.removeVehicleByVehicleNumber("petrol",1001);
	
	}
	
	
	@Test
	public void testmodifyEmployeeForNoSuchEmployeeException() {
		vehicleService.modifyVehicle(vehicletest);
	}
	
	
	@Test
	public void testfindAllVehiclesForListNotNull(){
		List<Vehicle>  vehicleList;
		
			vehicleList = vehicleService.findAllVehicles();
			assertNotNull(vehicleList);
		
	}
	
}
