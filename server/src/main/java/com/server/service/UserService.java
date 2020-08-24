package com.server.service;

import com.server.entity.Customer;
import com.server.entity.User;

public interface UserService {

    void register(Customer customer) throws Exception;
    
    void register(User user) throws Exception;

	Customer login(String email, String password);

}