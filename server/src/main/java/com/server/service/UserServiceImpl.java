package com.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entity.Customer;
import com.server.exception.UserServiceException;
import com.server.repository.UserRepository;

//@Component
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void register(Customer customer) {
		if(! userRepository.isCustomerPresent(customer.getEmailId())) {
			userRepository.save(customer);
		}
		else {
			throw new UserServiceException("Customer already registered");
		}
		
	}

	@Override
	public Customer login(String email, String password) {
		return null;
	}
	
}