package com.server.repository;

import java.util.List;

import com.server.entity.Customer;

public interface UserRepository {

	void save(Customer customer);

	Customer findById(int id);

	List<Customer> findAll();

	int findByUsernamePassword(String email, String password);

	boolean isCustomerPresent(String email);

}