package com.cg.citipark.daos;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.cg.citipark.utils.VehicleUtil;
import com.cg.citipark.models.Vehicle;


public class VehicleDaoImpl implements VehicleDao{
	
//	private static Logger logger=Logger.getLogger(Vehicle.class);
	VehicleUtil util = new VehicleUtil();

	@Override
	public boolean createUsersVehicle(Vehicle vehicle) throws SQLException {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(vehicle);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
		return true;
	}

	@Override
	public Vehicle readVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws SQLException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Vehicle read = entityManager.find(Vehicle.class, vehicleId);
		
		return read;
	}

	@Override
	public List<Vehicle> readAllVehiclesByUserId(int ownerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteVehicleByVehicleNumber(String vehicleNumber, long vehicleId) throws SQLException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		Vehicle delete = entityManager.find(Vehicle.class, vehicleId);
	
		entityManager.remove(delete);
	
		entityManager.getTransaction().commit();
		if(delete==null)
		{
			return false;
		}
		return true;
	}

	@Override
	public Vehicle updateVehicle(Vehicle vehicle) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.merge(vehicle);
	
		entityManager.getTransaction().commit();
		return vehicle;
	}

	@Override
	public List<Vehicle> readAllVehicles() {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
				
		TypedQuery<Vehicle> query = entityManager.createQuery("select v from Vehicle v",Vehicle.class);
		List<Vehicle> allVehicles = query.getResultList();
		entityManagerFactory.close();
		
		return allVehicles;
	}
	
	public Vehicle getVehicleById(long updateId)
	{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Vehicle find = entityManager.find(Vehicle.class, updateId);
		
		return find;
	}

}
