package com.lti.repository;

import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;
import com.lti.entity.Payment;

public interface MakePaymentRepository {

	void save(Object obj);

	Payment findPaymentDetailsByCustomerId(Customer customer);

	public boolean isUserValid(String email);

	int findCustomerIdByEmail(String email);
	
	public Customer getCustomerByEmail(String email);
}