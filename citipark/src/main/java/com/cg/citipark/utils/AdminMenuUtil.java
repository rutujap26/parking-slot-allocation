package com.cg.citipark.utils;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.citipark.exceptions.DuplicateParkingFloorException;
import com.cg.citipark.exceptions.DuplicateParkingPremiseException;
import com.cg.citipark.exceptions.InvalidLoginCredentialException;
import com.cg.citipark.exceptions.NoSuchParkingFloorException;
import com.cg.citipark.exceptions.NoSuchParkingPremiseException;
import com.cg.citipark.exceptions.NoSuchUserException;
import com.cg.citipark.models.Address;
import com.cg.citipark.models.Admin;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;
import com.cg.citipark.services.AdminService;
import com.cg.citipark.services.AdminServiceImpl;


public class AdminMenuUtil {

	public void start() throws InvalidLoginCredentialException, SQLException, NoSuchParkingPremiseException,
			NoSuchParkingFloorException, DuplicateParkingPremiseException, DuplicateParkingFloorException, NoSuchUserException {
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		AdminService adminService = new AdminServiceImpl();
		int choice;
		String continueChoice;
		Scanner sc = new Scanner(System.in);
		do {
			showMenu();
			System.out.println("Enter Your Choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				Admin admin = new Admin();
				System.out.println("Enter Login Id: ");
				admin.setLoginId(sc.next());
				System.out.println("Enter Password: ");
				admin.setPassword(sc.next());
				adminService.login(admin);
				break;

			case 2:
				System.out.println("Adding Parking Premise");
				Address add = new Address();
				System.out.println("Enter City: ");
				add.setCity(sc.next());
				System.out.println("Enter State: ");
				add.setState(sc.next());
				System.out.println("Enter Pincode: ");
				add.setPin(sc.next());
				ParkingPremise pp = new ParkingPremise();
				System.out.println("Enter Premise Name: ");
				pp.setParkingPremiseName(sc.next().toUpperCase());
				System.out.println("Enter Number of Parking Floors: ");
				pp.setNumberOfParkingFloors(sc.nextInt());
				pp.setPremiseAddress(add);
				adminService.addParkingPremise(pp);
				break;

			case 3:
				System.out.println("Enter Parking Premise Id");
				ParkingPremise premiseById = adminService.getParkingPremiseById(sc.nextInt());
				System.out.println(premiseById.getNumberOfParkingFloors());
				System.out.println(premiseById.getParkingPremiseId());
				System.out.println(premiseById.getParkingPremiseName());
				System.out.println(premiseById.getPremiseAddress());
				break;

			case 4:
				System.out.println("Enter Name of Parking Premise: ");
				String pname = sc.next().toUpperCase();
				List<ParkingPremise> premiseByName = adminService.getParkingPremiseByName(pname);
				for(ParkingPremise pr : premiseByName) {
					System.out.println(pr.getNumberOfParkingFloors());
					System.out.println(pr.getParkingPremiseId());
					System.out.println(pr.getParkingPremiseName());
					System.out.println(pr.getPremiseAddress());
				}
				break;

			case 5:
				System.out.println("List Of Parking Premises: ");
				List<ParkingPremise> premises = adminService.getAllParkingPremises();
				for(ParkingPremise pr: premises) {
					System.out.println(pr.getNumberOfParkingFloors());
					System.out.println(pr.getParkingPremiseId());
					System.out.println(pr.getParkingPremiseName());
					System.out.println(pr.getPremiseAddress());
				}
				break;

			case 6:
				System.out.println("Enter Parking Premise Id: ");
				ParkingPremise preMod = new ParkingPremise();
				preMod.setParkingPremiseId(sc.nextInt());
				System.out.println("Enter Number of Parking Floors: ");
				preMod.setNumberOfParkingFloors(sc.nextInt());
				System.out.println("Enter Parking Premise Name: ");
				preMod.setParkingPremiseName(sc.next());
				System.out.println("Enter Address Id: ");
				Address addMod = em.find(Address.class, sc.nextInt());
				preMod.setPremiseAddress(addMod);
				ParkingPremise premiseMod = adminService.modifyParkingPremise(preMod);
				System.out.println(premiseMod.getNumberOfParkingFloors());
				System.out.println(premiseMod.getParkingPremiseId());
				System.out.println(premiseMod.getParkingPremiseName());
				System.out.println(premiseMod.getPremiseAddress());
				break;

			case 7:
				System.out.println("Enter Parking Premise Id");
				int ppId = sc.nextInt();
				adminService.removeParkingPremise(ppId);
				break;

			case 8:
				System.out.println("Adding Parking Floor");
				Address addAdd = new Address();
				System.out.println("Enter City: ");
				addAdd.setCity(sc.next());
				System.out.println("Enter State: ");
				addAdd.setState(sc.next());
				System.out.println("Enter Pincode: ");
				addAdd.setPin(sc.next());
				ParkingPremise addPremise = new ParkingPremise();
				System.out.println("Enter Premise Name: ");
				addPremise.setParkingPremiseName(sc.next());
				System.out.println("Enter Number of Parking Floors: ");
				addPremise.setNumberOfParkingFloors(sc.nextInt());
				addPremise.setPremiseAddress(addAdd);
				ParkingFloor addFloor = new ParkingFloor();
				System.out.println("Enter Floor Number: ");
				addFloor.setFloorNumber(sc.next());
				System.out.println("Enter Number of Parking Slots: ");
				addFloor.setNumberOfParkingSlots(sc.nextInt());
				addFloor.setParkingPremise(addPremise);
				adminService.addParkingFloor(addFloor);
				break;

			case 9:
				System.out.println("Enter Parking Floor Id: ");
				int pfId = sc.nextInt();
				ParkingFloor floorById = adminService.getParkingFloorById(pfId);
				System.out.println(floorById.getParkingFloorId());
				System.out.println(floorById.getFloorNumber());
				System.out.println(floorById.getNumberOfParkingSlots());
				System.out.println(floorById.getParkingPremise());
				break;

			case 10:
				System.out.println("Enter Floor Number");
				String fNo = sc.next();
				List<ParkingFloor> results = adminService.getParkingFloorByNumber(fNo);
				for(ParkingFloor f : results) {
					System.out.println(f.getParkingFloorId());
					System.out.println(f.getFloorNumber());
					System.out.println(f.getNumberOfParkingSlots());
					System.out.println(f.getParkingPremise());
				}
				break;

			case 11:
				System.out.println("Get All Parking Floors");
				List<ParkingFloor> floors = adminService.getAllParkingFloors();
				for(ParkingFloor f : floors) {
					System.out.println(f.getParkingFloorId());
					System.out.println(f.getFloorNumber());
					System.out.println(f.getNumberOfParkingSlots());
					System.out.println(f.getParkingPremise());
				}
				break;

			case 12:
				System.out.println("Enter Parking Floor Id: ");
				ParkingFloor pf = new ParkingFloor();
				pf.setParkingFloorId(sc.nextInt());
				System.out.println("Enter Number of Parking Slots: ");
				pf.setNumberOfParkingSlots(sc.nextInt());
				System.out.println("Enter Floor Number: ");
				pf.setFloorNumber(sc.next());
				System.out.println("Enter Parking Premise Id: ");
				ParkingPremise ppMod = em.find(ParkingPremise.class, sc.nextInt());
				pf.setParkingPremise(ppMod);
				ParkingFloor modFloor = adminService.modifyParkingCapacity(pf);
				System.out.println(modFloor.getParkingFloorId());
				System.out.println(modFloor.getFloorNumber());
				System.out.println(modFloor.getNumberOfParkingSlots());
				System.out.println(modFloor.getParkingPremise());
				break;

			case 13:
				System.out.println("Enter Parking Floor Id");
				int pfId1 = sc.nextInt();
				adminService.removeParkingFloor(pfId1);
				break;

			case 0:
				System.exit(0);
				break;

			default:
				System.out.println("Wrong Choice");
				break;
			}
			System.out.println("Do you want to continue:[yes/no] : ");
			continueChoice = sc.next();
		} while (continueChoice.equalsIgnoreCase("yes"));

		em.getTransaction().commit();
		em.close();
		emf.close();
	}

	private void showMenu() {
		System.out.println("-----Admin Menu-----");
		System.out.println("1. Login");
		System.out.println("2. Add Parking Premise");
		System.out.println("3. Get Parking Premise By Id");
		System.out.println("4. Get Parking Premise By Name");
		System.out.println("5. Get All Parking Premises");
		System.out.println("6. Modify Parking Premise");
		System.out.println("7. Remove Parking Premise");
		System.out.println("8. Add Parking Floor");
		System.out.println("9. Get Parking Floor By Id");
		System.out.println("10. Get Parking Floor By Number");
		System.out.println("11. Get All Parking Floors");
		System.out.println("12. Modify Parking Capacity");
		System.out.println("13. Remove Parking Floor");
		System.out.println("0. Exit");
	}

}

