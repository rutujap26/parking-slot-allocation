package com.cg.citipark.services;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.cg.citipark.exceptions.NoSuchPaymentFoundException;
import com.cg.citipark.exceptions.PaymentFailureException;
import com.cg.citipark.models.Payment;



public interface PaymentService {
	
	public boolean parkingBookingPayment(Payment payment) throws PaymentFailureException, SQLException;
	public Payment findPaymentById(long paymentId) throws NoSuchPaymentFoundException, SQLException;
	public List<Payment> getAllPayment() throws NoSuchPaymentFoundException,SQLException;
	public List<Payment> getAllPayments(LocalDate date) throws NoSuchPaymentFoundException, SQLException;

}
