package com.server.repository;

import com.server.entity.Customer;
import com.server.entity.Vehicle;

public interface BuyInsuranceRepository {
	
	boolean isSameVehicleIsInsuredAlready(String registrationNo);
	
	void submitData(Vehicle vehicle);

}