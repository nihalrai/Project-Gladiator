package com.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.exception.UserServiceException;
import com.server.dto.LoginStatusDto;
import com.server.dto.StatusDto;

@RestController
@CrossOrigin
public class UserLoginController {

	//@Autowired
	//private LoginrService loginService;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginStatusDto login(@RequestBody LoginStatusDto loginDto) {

		try {
			//Implementatation
			
			LoginStatusDto status = new LoginStatusDto();
			return status;

		} catch (Exception e) {
			LoginStatusDto status = new LoginStatusDto();

			if (e instanceof UserServiceException) {
				e.printStackTrace();
				status.setMessage(e.getMessage());
			} else {
				e.printStackTrace();
				status.setMessage(e.getMessage());
			}

			status.setStatus(StatusDto.StatusType.FAILURE);

			return status;
		}

	}

}