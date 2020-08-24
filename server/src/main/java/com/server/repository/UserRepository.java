package com.server.repository;

import java.util.List;

import com.server.entity.Customer;
import com.server.entity.User;

public interface UserRepository {

    void save(Customer customer);
    
    void save(User user);

	Customer findById(int id);

	List<Customer> findAll();

	int findByUsernamePassword(String email, String password);

	boolean isCustomerPresent(String email);

}