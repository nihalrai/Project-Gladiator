package com.lti.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Claim;

@RestController
@CrossOrigin
public class AdminDashboardController {
	@GetMapping(path = "/getAllClaimData", produces = "application/json")
	public List<Claim> getAllClaimData() {
		return null;
	}
	
	//to approve or not approved part or set amount of claim is implement in claim-insurance controller
}
