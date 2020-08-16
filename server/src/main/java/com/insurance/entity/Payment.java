package com.insurance.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "PAYMENT")
public class Payment {
	@Id
	@SequenceGenerator(name = "id", initialValue = 1, allocationSize = 1)
	@GeneratedValue
	private int id;

	@Column(name = "mode", nullable = false)
	private String mode;

	@Column(name = "date", nullable = false)
	private LocalDate date;

	@Column(name = "amount", nullable = false)
	private double amount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	public Payment() {
		super();
	}

	public Payment(int id, String mode, LocalDate date, double amount, Customer customer) {
		super();
		this.id = id;
		this.mode = mode;
		this.date = date;
		this.amount = amount;
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
