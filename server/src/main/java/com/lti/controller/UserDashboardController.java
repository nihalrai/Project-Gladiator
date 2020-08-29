package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Claim;
import com.lti.entity.Policy;
import com.lti.service.DashboardService;

@RestController
@CrossOrigin
public class UserDashboardController {
	@Autowired
	private DashboardService dashboardService;
	
	@GetMapping(path = "/getUserInsuranceCount", produces = "application/json")
	public long getUserInsuranceCount() {
		return 0;
	}

	@GetMapping(path = "/getClaim", produces = "application/json")
	public Claim getClaimHistory() {
		return null;
	}

	
}
