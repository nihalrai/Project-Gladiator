package com.lti.service;

import com.lti.entity.Customer;
import com.lti.entity.Vehicle;
import com.lti.exception.InsuranceServiceException;

public interface BuyInsuranceService {

	void submissionOfBuyInsuranceDetails(Vehicle vehicle) throws InsuranceServiceException;

	Customer findById(int id);

}