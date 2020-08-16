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
@Table(name = "CUSTOMER")
public class Customer {
	
	@Id
	@SequenceGenerator(name = "id", initialValue = 1, allocationSize=1)
	@GeneratedValue
	private int id;
	
	@Column(name = "first_name", nullable=false)
	private String first_name;
	
	@Column(name = "last_name", nullable=false)
	private String last_name;
	
	@Column(name = "email", nullable=false, unique = true)
	private String email_id;
	
	@Column(name = "date_of_birth", nullable=false)
	private LocalDate date_of_birth;
	
	@Column(name = "contact_no", nullable=false)
	private int contact_no;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="addr_id")
	private Address address;
	
	public Customer() {
		super();
	}

	public Customer(int id, String first_name, String last_name, String email_id, LocalDate date_of_birth,
			int contact_no, Address address) {
		super();
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email_id = email_id;
		this.date_of_birth = date_of_birth;
		this.contact_no = contact_no;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public LocalDate getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(LocalDate date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
