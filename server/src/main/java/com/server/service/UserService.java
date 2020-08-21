package com.server.service;

import com.server.entity.Customer;

public interface UserService {

	void register(Customer customer) throws Exception;

	Customer login(String email, String password);

}