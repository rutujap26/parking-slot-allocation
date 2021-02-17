package com.cg.citipark.utils;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.cg.citipark.daos.VehicleDaoImpl;
import com.cg.citipark.models.Vehicle;
import com.cg.citipark.services.VehicleServiceImpl;



public class VehicleUtil {

	public void vehicleStart() throws Exception
	{
		while(true)
		{
		LocalDate sdate=LocalDate.now();
		LocalDate udate=LocalDate.now();
		Scanner sc=new Scanner(System.in);
		System.out.println("Choose Option:");
		System.out.println("1.Add your vehicle:");
		System.out.println("2.Find your vehicle by Vehicle Number:");
		System.out.println("3.Find all vehicles by Owner Id");
		System.out.println("4.Remove your vehicle by Vehicle Number:");
		System.out.println("5.Modify your vehicle by Id:");
		System.out.println("6.View all vehicles");
		System.out.println("7.Exit:");
		int choose=sc.nextInt();
		VehicleDaoImpl dao = new VehicleDaoImpl();
		VehicleServiceImpl service = new VehicleServiceImpl();
		switch(choose)
		{
		case 1:
			System.out.println("Enter the vehicle id");
			long vehicleId =sc.nextLong();
			System.out.println("Enter the number ");
			String vehicleNumber=sc.next();
			System.out.println("Enter the vehicle company");
			String vehicleCompany=sc.next();
			System.out.println("Enter the model");
			String vehicleModel=sc.next();
			System.out.println("Enetr the vehicleType");
			String vehicleType=sc.next();
			Vehicle vehicle = new Vehicle(vehicleId, vehicleNumber, vehicleCompany, vehicleModel,vehicleType);
			service.addUsersVehicle(vehicle);	
			System.out.println("Enter booking slot");
			ParkingUtil parkingutil=new ParkingUtil();
			parkingutil.parkingStart();
			break;
			
		case 2:
			System.out.println("Enter your Vehicle Number:");
			vehicleNumber=sc.next();
			System.out.println("Enter your Vehicle Id:");
			vehicleId=sc.nextLong();
			
			Vehicle findByNumber = service.findVehicleByVehicleNumber(vehicleNumber, vehicleId);
			System.out.println(findByNumber.toString());
			break;
		case 3:
			
			break;
			
		case 4:
			System.out.println("Enter your Vehicle Number:");
			vehicleNumber=sc.next();
			System.out.println("Enter your Vehicle Id:");
			vehicleId=sc.nextLong();
			
			boolean check = service.removeVehicleByVehicleNumber(vehicleNumber, vehicleId);
			if(check ==  true)
			{
				System.out.println("Vehicle Deleted");
			}
			else
			{
				System.out.println("Vehicle not found");
			}
			break;
			
		case 5:
			System.out.println("Enter the vehicle Id to update");
			long id = sc.nextLong();
			vehicle = service.findByVehicleId(id);
			if(vehicle!=null)
			{
				System.out.println("Enter the vehicle number to update");
				String updateVehicleNumber=sc.next();
				vehicle.setVehicleNumber(updateVehicleNumber);
				System.out.println("Enter the vehicle company to update");
				String updateVehicleCompany=sc.next();
				vehicle.setVehicleCompany(updateVehicleCompany);
				System.out.println("Enter the model to update");
				String updateVehicleModel=sc.next();
				vehicle.setVehicleCompany(updateVehicleModel);
				System.out.println("Enter the vehicletype to update");
				String updateVehicleType=sc.next();
				vehicle.setVehicleCompany(updateVehicleType);
				
				service.modifyVehicle(vehicle);
				System.out.println("Updated Successfully");
			}
			else
			{
				System.out.println("Vehicle not found");
			}
			break;
			
		case 6:
			System.out.println("All Vehicles");
			List<Vehicle> allVehicles = service.findAllVehicles();
			for(Vehicle v : allVehicles)
			{
				System.out.println(v.toString());
			}
			break;
		
			
		case 7:
			System.out.println("Thank you! Comes Again!!");
			System.exit(0);
			
		}
	}
		
}
}
