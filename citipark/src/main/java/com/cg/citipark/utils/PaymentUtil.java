package com.cg.citipark.utils;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

import com.cg.citipark.exceptions.NoSuchPaymentFoundException;
import com.cg.citipark.models.Payment;
import com.cg.citipark.models.PaymentStatus;
import com.cg.citipark.models.PaymentType;
import com.cg.citipark.services.PaymentServiceImpl;

public class PaymentUtil {
	public void paymentStart() throws Exception{
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("Choose Option:");
			System.out.println("1.parkingBookingPayment");
			System.out.println("2.Find your payment by id:");
			System.out.println("3.Find all payments");
			System.out.println("4.date:");
			int choose=sc.nextInt();
			Payment payment=new Payment();
			PaymentServiceImpl service = new PaymentServiceImpl();
			int typeOfPayment = 0;
			switch(choose)
			{
			case 1:
				//System.out.println("Enter the payment id:");
				//payment.setPaymentId(sc.nextLong());
				System.out.println("Parking Date automatically filled:");
				LocalDate date = java.time.LocalDate.now();
				payment.setDate(date);
				System.out.println("Parking Time automatically filled:");
				LocalTime time = java.time.LocalTime.now();
				payment.setTime(time);
				System.out.println("Choose any of the type of payment & Enter the option:");
				System.out.println("1. CASH_TO_BE_PAID	2. CREDIT_CARD	3.DEBIT_CARD 4.INTERNET_BANKING");
				typeOfPayment = sc.nextInt();
				if(typeOfPayment == 1) {
					payment.setPaymentType(PaymentType.CASH_TO_BE_PAID);
				}
				if(typeOfPayment == 2) {
					payment.setPaymentType(PaymentType.CREDIT_CARD);
				}
				if(typeOfPayment == 3) {
					payment.setPaymentType(PaymentType.DEBIT_CARD);
				}
				if(typeOfPayment == 4) {
					payment.setPaymentType(PaymentType.INTERNET_BANKING);
				}

				//payment.setPaymentType(PaymentType.CASH_TO_BE_PAID);
				System.out.println("Enter amount to be paid:");
				payment.setAmountPaid(sc.nextDouble());
				if(payment.getAmountPaid()!=0) {
					payment.setPaymentStatus(PaymentStatus.CONFIRMED);
				}
				else {
					payment.setPaymentStatus(PaymentStatus.CANCELLED);
				}
				service.parkingBookingPayment(payment);			
				break;


			case 2:
				System.out.println("Enter your payment Id:");
				long paymentId=sc.nextLong();
				try {
					System.out.println(service.findPaymentById(paymentId));
				}catch(NoSuchPaymentFoundException e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("All Payments");
				List<Payment> list = service.getAllPayment();
				for (Payment p : list) {
					System.out.println(p);
				}
				break;
			case 4:
				sc.nextLine();
//				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				System.out.println("Enter date in the YYYY-MM-DD formate");
				LocalDate date1;
				try {
					date1=LocalDate.parse(sc.nextLine());
				}
				catch(Exception ex){ throw new ParseException(ex.getMessage(), 0);}
				List<Payment> paymentList = service.getAllPayments(date1);
				for(Payment i : paymentList) {
					System.out.println(i.toString());
				}
				break;
			}
		}

	}
}



