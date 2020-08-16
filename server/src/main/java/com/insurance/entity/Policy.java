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
@Table(name = "POLICY")
public class Policy {

	@Id
	@SequenceGenerator(name = "id", initialValue = 1, allocationSize = 1)
	@GeneratedValue
	private int id;

	@Column(name = "status", nullable = false)
	private String status;

	@Column(name = "issue_date", nullable = false)
	private LocalDate issue_date;

	@Column(name = "expiry_date", nullable = false)
	private LocalDate expiry_date;

	@Column(name = "duration", nullable = false)
	private int duration;

	@Column(name = "policy_amount", nullable = false)
	private double policy_amount;

	@Column(name = "plan_amount", nullable = false)
	private double plan_amount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "insurance_plan_id")
	private InsurancePlan insurancePlan;

	public Policy() {
		super();
	}

	public Policy(int id, String status, LocalDate issue_date, LocalDate expiry_date, int duration,
			double policy_amount, double plan_amount, Customer customer, InsurancePlan insurancePlan) {
		super();
		this.id = id;
		this.status = status;
		this.issue_date = issue_date;
		this.expiry_date = expiry_date;
		this.duration = duration;
		this.policy_amount = policy_amount;
		this.plan_amount = plan_amount;
		this.customer = customer;
		this.insurancePlan = insurancePlan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(LocalDate issue_date) {
		this.issue_date = issue_date;
	}

	public LocalDate getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(LocalDate expiry_date) {
		this.expiry_date = expiry_date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getPolicy_amount() {
		return policy_amount;
	}

	public void setPolicy_amount(double policy_amount) {
		this.policy_amount = policy_amount;
	}

	public double getPlan_amount() {
		return plan_amount;
	}

	public void setPlan_amount(double plan_amount) {
		this.plan_amount = plan_amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public InsurancePlan getInsurancePlan() {
		return insurancePlan;
	}

	public void setInsurancePlan(InsurancePlan insurancePlan) {
		this.insurancePlan = insurancePlan;
	}

}
