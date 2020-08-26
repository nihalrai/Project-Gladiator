package com.server.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.server.entity.Claim;
import com.server.entity.Policy;

@RestController
@CrossOrigin
public class UserDashboardController {
	@GetMapping(path = "/getInsurance", produces = "application/json")
	public Policy getInsurance() {
		return null;
	}
	
	@GetMapping(path = "/getClaim", produces = "application/json")
	public Claim getClaimHistory() {
		return null;
	}
}
