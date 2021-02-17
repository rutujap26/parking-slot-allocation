package com.cg.citipark.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPA-PU");
	protected static EntityManager em =emf.createEntityManager();
	public static EntityManager getEntityManager() {
		if(em==null||!em.isOpen())	{
			em=emf.createEntityManager();
		}
		return em;
	}
	
}
