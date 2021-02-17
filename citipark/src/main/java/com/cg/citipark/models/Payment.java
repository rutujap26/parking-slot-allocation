package com.cg.citipark.models;
//import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.*;

@Entity
@Table(name="payments")
public class Payment {
	@Id
	@GeneratedValue
	private long paymentId;
	@Enumerated(value=EnumType.STRING)
	private PaymentType paymentType;
	private double amountPaid;
	@Enumerated(value=EnumType.STRING)
	private PaymentStatus paymentStatus;
	private LocalDate date;
	private LocalTime time;
	/*
	 * Parameterized constructor
	 */
	public Payment(long paymentId,LocalDate date,LocalTime time,double amountPaid) {
		super();
		this.paymentId = paymentId;
		this.date=date;
		this.time=time;
		this.amountPaid = amountPaid;
	}
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	//getters and setters
	public long getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalTime getTime() {
		return time;
	}
	public void setTime(LocalTime time) {
		this.time = time;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentType=" + paymentType + ", amountPaid=" + amountPaid
				+ ", paymentStatus=" + paymentStatus + ", date=" + date + ", time=" + time + "]";
	}






}
