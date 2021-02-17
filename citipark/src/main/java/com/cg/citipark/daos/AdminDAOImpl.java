package com.cg.citipark.daos;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.citipark.models.Address;
import com.cg.citipark.models.Admin;
import com.cg.citipark.models.ParkingFloor;
import com.cg.citipark.models.ParkingPremise;
import com.cg.citipark.utils.JPAUtil;

public class AdminDAOImpl implements AdminDAO {
	
	@Override
	public Admin login(Admin login) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		Admin admin = entityManager.find(Admin.class, login.getLoginId());
		entityManager.getTransaction().commit();
		entityManager.close();
		return admin;
	}

	@Override
	public boolean createParkingPremise(ParkingPremise parkingPremise){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingPremise premise = entityManager.find(ParkingPremise.class, parkingPremise.getParkingPremiseId());
		Address address = parkingPremise.getPremiseAddress();
		if(premise==null) {
			entityManager.persist(address);
			entityManager.persist(parkingPremise);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return false;
	}

	@Override
	public ParkingPremise readParkingPremiseById(int parkingPremiseId){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingPremise premise = entityManager.find(ParkingPremise.class, parkingPremiseId);
		entityManager.getTransaction().commit();
		entityManager.close();
		return premise;
	}

	@Override
	public List<ParkingPremise> readParkingPremiseByName(String premiseName){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		String jpql = "SELECT pp FROM ParkingPremise pp WHERE pp.parkingPremiseName=:name";
		TypedQuery<ParkingPremise> query = entityManager.createQuery(jpql, ParkingPremise.class);
		query.setParameter("name", premiseName);
		List<ParkingPremise> result = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		if(result.isEmpty())
			return null;
		return result;
	}

	@Override
	public List<ParkingPremise> readAllParkingPremises() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		String jpql = "Select p From ParkingPremise p";
		TypedQuery<ParkingPremise> query = entityManager.createQuery(jpql, ParkingPremise.class);
		List<ParkingPremise> result = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	@Override
	public ParkingPremise updateParkingPremise(ParkingPremise parkingPremise) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingPremise premise = entityManager.find(ParkingPremise.class, parkingPremise.getParkingPremiseId());
		premise = entityManager.merge(parkingPremise);
		entityManager.getTransaction().commit();
		entityManager.close();
		return premise;
	}

	@Override
	public boolean deleteParkingPremise(int parkingPremiseId){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingPremise premise = entityManager.find(ParkingPremise.class, parkingPremiseId);
		if(premise!=null) {
			entityManager.remove(premise);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return false;
	}

	@Override
	public boolean createParkingFloor(ParkingFloor parkingFloor) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingFloor floor = entityManager.find(ParkingFloor.class, parkingFloor.getParkingFloorId());
		ParkingPremise premise = parkingFloor.getParkingPremise();
		Address address = premise.getPremiseAddress();
		if(floor==null) {
			entityManager.persist(address);
			entityManager.persist(premise);
			entityManager.persist(parkingFloor);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return false;
	}

	@Override
	public ParkingFloor readParkingFloorById(int parkingFloorId){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingFloor floor = entityManager.find(ParkingFloor.class, parkingFloorId);
		entityManager.getTransaction().commit();
		entityManager.close();
		return floor;
	}

	@Override
	public List<ParkingFloor> readParkingFloorByNumber(String floorNumber){
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		String jpql = "SELECT pf FROM ParkingFloor pf WHERE pf.floorNumber=:floor";
		TypedQuery<ParkingFloor> query = entityManager.createQuery(jpql, ParkingFloor.class);
		query.setParameter("floor", floorNumber);
		List<ParkingFloor> result = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		if(result.isEmpty())
			return null;
		return result;
	}

	@Override
	public List<ParkingFloor> readAllParkingFloors() {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		String jpql = "Select pf From ParkingFloor pf";
		TypedQuery<ParkingFloor> query = entityManager.createQuery(jpql, ParkingFloor.class);
		List<ParkingFloor> result = query.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		return result;
	}

	@Override
	public ParkingFloor updateParkingCapacity(ParkingFloor parkingFloor) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingFloor floor = entityManager.find(ParkingFloor.class, parkingFloor.getParkingFloorId());
		floor= entityManager.merge(parkingFloor);
		entityManager.getTransaction().commit();
		entityManager.close();
		return floor;
	}

	@Override
	public boolean deleteParkingFloor(int parkingFloorId) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		ParkingFloor floor = entityManager.find(ParkingFloor.class, parkingFloorId);
		if(floor!=null) {
			entityManager.remove(floor);
			entityManager.getTransaction().commit();
			entityManager.close();
			return true;
		}
		entityManager.getTransaction().commit();
		entityManager.close();
		return false;
	}

}