package com.cg.citipark.daos;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.citipark.exceptions.NoSuchPaymentFoundException;
import com.cg.citipark.models.Payment;
import com.cg.citipark.utils.PaymentUtil;


public class PaymentDAOImpl implements PaymentDAO {
	PaymentUtil util=new PaymentUtil();
	public boolean parkingBookingPayment(Payment payment) throws SQLException{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		
		entityManager.persist(payment);
		entityManager.getTransaction().commit();
		entityManagerFactory.close();
		entityManager.close();
		return true;
	}
	public Payment readPaymentById(long paymentId) throws NoSuchPaymentFoundException,SQLException{

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Payment read = entityManager.find(Payment.class, paymentId);
		if(read==null) {
				throw new NoSuchPaymentFoundException("No such payment found");
		}
		return read;
	}
	public List<Payment> getAllPayment() throws SQLException{
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String selectQuery = "select e from Payment e";
		TypedQuery<Payment> query = entityManager.createQuery(selectQuery,Payment.class);
		List<Payment> list = query.getResultList();
		return list;
	}

	@Override
	public List<Payment> getAllPayments(LocalDate date) throws NoSuchPaymentFoundException,SQLException {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("JPA-PU");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String selectQuery = "select e from Payment e where date=?1";
		Query query = entityManager.createQuery(selectQuery,Payment.class);
		query.setParameter(1,date);
		List<Payment> list=query.getResultList();
		return list;
	}
		

}
