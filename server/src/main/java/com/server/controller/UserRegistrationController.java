package com.server.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.server.dto.CustomerDto;
import com.server.dto.StatusDto;
import com.server.entity.Customer;
import com.server.exception.UserServiceException;
import com.server.service.UserService;

public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping(path = "/register", consumes = "multipart/form-data", produces = "application/json")
	public StatusDto register(@RequestBody CustomerDto customerDto) {
		try {
			
			Customer customer = new Customer();
			
			BeanUtils.copyProperties(customerDto, customer);
			
			userService.register(customer);
			
			StatusDto status = new StatusDto();
			status.setMessage("Registered successfully!");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			return status;

		} catch (Exception e) {
			e.printStackTrace();
			StatusDto status = new StatusDto();

			if (e instanceof UserServiceException) {
				status.setMessage(e.getMessage());
			} else {
				status.setMessage(e.getMessage());
			}

			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		}

	}

}
