package com.lti.repository;

import org.springframework.transaction.annotation.Transactional;

import com.lti.entity.Customer;
import com.lti.entity.Vehicle;

public interface BuyInsuranceRepository {

	void submissionOfBuyInsuranceData(Vehicle vehicle);

	boolean isSameVehicleIsInsuredAlready(String registrationNo);

	Customer findById(int id);

}