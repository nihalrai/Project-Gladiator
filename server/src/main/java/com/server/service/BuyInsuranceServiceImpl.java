package com.server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.entity.Vehicle;
import com.server.exception.BuyInsuranceServiceException;
import com.server.repository.BuyInsuranceRepository;

@Service
public class BuyInsuranceServiceImpl implements BuyInsuranceService {
	@Autowired
	private BuyInsuranceRepository buyInsuranceRepo;
	
	@Override
	public void submissionOfInsuranceDetails(Vehicle vehicle) throws BuyInsuranceServiceException {
		if(!buyInsuranceRepo.isSameVehicleIsInsuredAlready(vehicle.getRegistrationNo())) {
			buyInsuranceRepo.submitData(vehicle);
		}else {
			throw new BuyInsuranceServiceException("This Vehicle is already Insured, you have to renew the insurance");
		}
	}
}
