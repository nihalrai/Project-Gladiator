package com.server.service;

import org.springframework.stereotype.Service;

import com.server.entity.Vehicle;
import com.server.exception.BuyInsuranceServiceException;

public interface BuyInsuranceService {

	void submissionOfInsuranceDetails(Vehicle vehicle) throws BuyInsuranceServiceException;

}