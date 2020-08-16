package com.insurance.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Entity;

@Entity
@Table(name = "INSURANCE_PLAN")
public class InsurancePlan {
	
	@Id
	@SequenceGenerator(name = "id", initialValue = 1, allocationSize=1)
	@GeneratedValue
	private int id;
	
	@Column(name = "name", nullable=false)
	private String name;
	
	@Column(name = "type", nullable=false)
	private String type;
	
	@Column(name = "duration", nullable=false)
	private int duration;
	
	@Column(name = "amount", nullable=false)
	private double amount;
	
	@Column(name = "commission", nullable=false)
	private int commission;

	public InsurancePlan() {
		super();
	}

	public InsurancePlan(int id, String name, String type, int duration, double amount, int commission) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.duration = duration;
		this.amount = amount;
		this.commission = commission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getCommission() {
		return commission;
	}

	public void setCommission(int commission) {
		this.commission = commission;
	}	
}
