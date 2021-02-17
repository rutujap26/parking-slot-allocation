package com.cg.citipark.daos;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.citipark.exceptions.ParkingSlotNotAvailableException;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;
import com.cg.citipark.models.ParkingSlots;
import com.cg.citipark.models.Vehicle;
import com.cg.citipark.services.ParkingService;
import com.cg.citipark.services.ParkingServiceImpl;

public class ParkingDAOImpl implements ParkingDAO {
	//ParkingDao dao=new ParkingDAOImpl();
	

	@Override
	public boolean checkAvailability(LocalDate date, String time) throws SQLException {
		// TODO Auto-generated method stub
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		TypedQuery<ParkingSlots> query = entityManager.createQuery("select p from ParkingSlots p ",ParkingSlots.class);
		List<ParkingSlots> allSlots = query.getResultList();
		for(ParkingSlots slot:allSlots)
		{
			if(slot.getParkingDate().compareTo(date)==0&&slot.getParkingTime().equals(time))
				return false;
				
		}
		return true;
	}

	@Override
	public boolean bookParkingSlot(ParkingSlots slot) throws SQLException, ParkingSlotNotAvailableException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
entityManager.getTransaction().begin();
		//boolean check=dao.checkAvailability(slot.getParkingDate(), slot.getParkingTime());
		//if(check)
		//{
		entityManager.persist(slot);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		
		return true;
		//}
		//System.out.println("Slot is booked");
		//return false;		
	}

	
	@Override
	public boolean cancelParkingSlotBooking(long id) throws SQLException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		ParkingSlots parkingSlot = entityManager.find(ParkingSlots.class, id);
		entityManager.remove(parkingSlot);
		entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public List<ParkingSlots> readAllParkingSlotsByPremise(ParkingPremise parkingPremise) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ParkingSlots> readAllParkingSlotsByFloor(ParkingFloor parkingFloor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ParkingSlots readParkingSlotsById(long parkingSlotId) throws SQLException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		ParkingSlots find = entityManager.find(ParkingSlots.class, parkingSlotId);
		
		return find;
	}
	
	@Override
	public ParkingSlots createParkingSlots(ParkingSlots parkingslot) throws SQLException
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(parkingslot);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return parkingslot;
		
	}

	

}
