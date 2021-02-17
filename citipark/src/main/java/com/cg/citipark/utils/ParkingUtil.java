package com.cg.citipark.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import com.cg.citipark.daos.ParkingDAOImpl;
import com.cg.citipark.daos.VehicleDaoImpl;
import com.cg.citipark.exceptions.NoSuchParkingSlotException;
import com.cg.citipark.models.ParkingSlots;
import com.cg.citipark.services.ParkingServiceImpl;
import com.cg.citipark.services.VehicleServiceImpl;

public class ParkingUtil {
	
	public void parkingStart() throws Exception
	{
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Choose Option:");
			System.out.println("1.Check Availability");
			System.out.println("2.Book Slot");
			System.out.println("3.Cancel Parking Slot");
			System.out.println("4.Read all parking slots by premise");
			System.out.println("5.Read all parking slots by floor");
			System.out.println("6.Read all parking slots by id");
			int choose=sc.nextInt();
			ParkingDAOImpl dao = new ParkingDAOImpl();
			ParkingServiceImpl service = new ParkingServiceImpl();
			switch(choose)
			{
			case 1:
				System.out.println("Enter date ");
				
				String sDate1=sc.next();  
				DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d/MM/yyyy");
				LocalDate parkingDate1= LocalDate.parse(sDate1, formatter1);
				System.out.println("Enter time");
				String slotTime=sc.next();
				boolean check=service.checkAvailability(parkingDate1, slotTime);
				System.out.println(check);
				break;
				
			case 2:
				System.out.println("Enter Parking date");
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
				String parkingDate=sc.next(); 
				LocalDate parkingDate2= LocalDate.parse(parkingDate, formatter);
				System.out.println("Booking date");
				LocalDate bookingDate=LocalDate.now();
				System.out.println("Enter parking time");
				String parkingTime=sc.next();
				System.out.println("Enter parking duration");
				int duration=sc.nextInt();
				ParkingSlots parkingSlot=new ParkingSlots(parkingDate2, parkingTime, bookingDate, duration);
				
				boolean parkCheck= service.bookParkingSlot(parkingSlot);
				if(parkCheck)
				{
					PaymentUtil paymentUtil= new PaymentUtil();
					paymentUtil.paymentStart();
				}
				break;
			case 3:
				System.out.println("Enter id to delete");
				long id=sc.nextLong();
				boolean check1 = service.cancelParkingSlotBooking(id);
				if(check1 ==  true)
				{
					System.out.println("Slot Deleted");
				}
				else
				{
					throw new NoSuchParkingSlotException("Slot not found");
				}
				break;
				
			case 6:
				System.out.println("Enter slotid to view");
				long id1=sc.nextLong();
				ParkingSlots parking=service.getParkingSlotsById(id1);
				System.out.println(parking.toString());
				
				
						
				break;
				
			}
			
		}
	}

}
