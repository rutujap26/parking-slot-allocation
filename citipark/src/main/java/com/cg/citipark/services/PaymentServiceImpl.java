package com.cg.citipark.services;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.cg.citipark.daos.PaymentDAO;
import com.cg.citipark.daos.PaymentDAOImpl;
import com.cg.citipark.exceptions.NoSuchPaymentFoundException;
import com.cg.citipark.exceptions.PaymentFailureException;
import com.cg.citipark.models.Payment;

public class PaymentServiceImpl implements PaymentService{
	Payment payment= new Payment();
	PaymentDAO dao = new PaymentDAOImpl();
	@Override
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException, SQLException{
		return dao.parkingBookingPayment(payment);
	}	
	@Override
	public Payment findPaymentById(long paymentId) throws NoSuchPaymentFoundException, SQLException{
		return  dao.readPaymentById(paymentId);
	}
	@Override
	public List<Payment> getAllPayment() throws NoSuchPaymentFoundException,SQLException{
		return dao.getAllPayment();
	}
	public List<Payment> getAllPayments(LocalDate date) throws NoSuchPaymentFoundException, SQLException{
		return dao.getAllPayments(date);
	}
	
}
