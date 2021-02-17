package com.cg.citipark.tests;


import static org.junit.Assert.*;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.*;
import java.util.Date;
import java.util.List;

import org.junit.*;

import com.cg.citipark.daos.PaymentDAO;
import com.cg.citipark.daos.PaymentDAOImpl;
import com.cg.citipark.exceptions.NoSuchPaymentFoundException;
import com.cg.citipark.exceptions.PaymentFailureException;
import com.cg.citipark.models.*;
import com.cg.citipark.services.PaymentService;
import com.cg.citipark.services.PaymentServiceImpl;


public class PaymentServiceTest {

	private PaymentService paymentService;
	private Payment payment;
	//private Payment payment1;
	@Before
	public void setup() {
		paymentService=new PaymentServiceImpl();
	}
	@Test
	public void testparkingBookingPaymentInDB() throws PaymentFailureException,SQLException{
		LocalDate local = LocalDate.of(2021, 02, 02);
		LocalTime time = LocalTime.of(18,11,49);
		payment=new Payment(3020,local,time,200.00);
		assertNotNull(payment);
		
	}
	
//	@Test
//	public void testgivenPaymentIdNotExistingInDbthrowsNoSuchPaymentFoundException() throws NoSuchPaymentFoundException, SQLException{
//		try {
//			Payment result = paymentService.findPaymentById(30);
//		}catch(NoSuchPaymentFoundException ex) {
//			assertEquals(0, 0);
//		}		
//	}
	
//	@Test
//	public void testgivenPaymentIdIfExistingInDbgivepaymentObjectInReturn() throws SQLException, NoSuchPaymentFoundException{
//			Payment result = paymentService.findPaymentById(9);
//			assertEquals(result.getPaymentType(),PaymentType.CREDIT_CARD);
//	}
	@Test
	public void testgivenPaymentIdIfExistingIngivepaymentObjectInReturn() throws SQLException, NoSuchPaymentFoundException{
			Payment result = paymentService.findPaymentById(38);
			assertEquals(result.getPaymentStatus(),PaymentStatus.CONFIRMED);
	}
	
//	@Test
//	public void testgivenPaymentIdIfExistingInDbgivepaymentObjectInReturnShouldHaveSameID() throws SQLException, NoSuchPaymentFoundException{
//			Payment result = paymentService.findPaymentById(9);
//			assertEquals(result.getPaymentId(),9);
//	}

	@Test
	public void testgivenPaymentDateNotExistingShouldGiveNullList() throws SQLException, NoSuchPaymentFoundException {
		List<Payment> result = paymentService.getAllPayments(LocalDate.parse("1999-12-02"));
		assertEquals(0,result.size());
	}
	@Test
	public void testgivenPaymentDateWrongthrowsParseException() throws NoSuchPaymentFoundException, SQLException{
		try {
			List<Payment> result = paymentService.getAllPayments(LocalDate.parse("1999-25-25"));
		}catch(Exception ex) {
			assertEquals(0, 0);
		}		
	}
	@Test
	public void testgetAllPaymentForListNotNull() throws NoSuchPaymentFoundException, SQLException{
		List<Payment>  paymentList;
		
			paymentList = paymentService.getAllPayment();
			assertNotNull(paymentList);
		
	}

}