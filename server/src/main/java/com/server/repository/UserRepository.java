package com.server.repository;

import java.util.List;

import com.server.entity.Customer;
import com.server.entity.User;

public interface UserRepository {

    void save(Customer customer);
    
    void save(User user);

	Customer findCustomerById(int id);

	List<Customer> findAll();

	User findByEmailPassword(String email, String password);

	boolean isCustomerPresent(String email);

	boolean isUserPresent(String email);
	
	User findUserByResetToken(String user);
	 
	User findUserByEmail(String email);

}