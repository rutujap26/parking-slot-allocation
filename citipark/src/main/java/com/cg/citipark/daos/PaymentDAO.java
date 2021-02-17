package com.cg.citipark.daos;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.cg.citipark.exceptions.NoSuchPaymentFoundException;
import com.cg.citipark.models.Payment;

public interface PaymentDAO {
	public boolean parkingBookingPayment(Payment payment) throws SQLException;
	public Payment readPaymentById(long paymentId) throws NoSuchPaymentFoundException, SQLException;
	public List<Payment> getAllPayment() throws NoSuchPaymentFoundException,SQLException;
	public List<Payment> getAllPayments(LocalDate date) throws NoSuchPaymentFoundException,SQLException;
	

}
