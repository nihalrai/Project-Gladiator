package com.server.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.exception.UserServiceException;
import com.server.dto.LoginStatusDto;
import com.server.dto.StatusDto;
import com.server.entity.User;
import com.server.dto.LoginDto;
import com.server.service.UserService;

@RestController
@CrossOrigin
public class UserLoginController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginStatusDto login(@RequestBody LoginDto loginDto) {

		try {
			if (!userService.isUserPresent(loginDto.getEmail())) {
				throw new UserServiceException("User does not exists!");
			}

			List<String> sessionData = userService.login(loginDto.getEmail(), loginDto.getPassword());
			User user = userService.getUserByEmailandPassword(loginDto.getEmail(), loginDto.getPassword());
			user.setLastLogin(LocalDateTime.now());
			userService.addOrUpdateUser(user);
			
			if (sessionData == null) {
				throw new UserServiceException("Incorrect Password!");
			}

			LoginStatusDto status = new LoginStatusDto();
			status.setId(Integer.parseInt(sessionData.get(0)));
			status.setName(sessionData.get(1));
			status.setRole(sessionData.get(2));
			status.setMessage("Login Success");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			return status;

		} catch (Exception e) {
			LoginStatusDto status = new LoginStatusDto();
			status.setId(-1);
			status.setName(null);
			status.setRole(null);
			status.setStatus(StatusDto.StatusType.FAILURE);
			if (e instanceof UserServiceException) {
				//e.printStackTrace();
				status.setMessage(e.getMessage());
			} else {
				//e.printStackTrace();
				status.setMessage(e.getMessage());
			}
			return status;
		}

	}

	@PostMapping(path = "/admin/login", consumes = "application/json", produces = "application/json")
	public LoginStatusDto adminLogin(@RequestBody LoginDto loginDto) {

		try {
			List<String> sessionData = userService.login(loginDto.getEmail(), loginDto.getPassword());

			if (sessionData == null) {
				throw new UserServiceException("Incorrect Password!");
			}

			LoginStatusDto status = new LoginStatusDto();
			status.setId(Integer.parseInt(sessionData.get(0)));
			status.setName(sessionData.get(1));
			status.setRole(sessionData.get(2));
			status.setMessage("Login Success");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			return status;

		} catch (Exception e) {
			LoginStatusDto status = new LoginStatusDto();
			status.setId(-1);
			status.setName(null);
			status.setRole(null);
			status.setStatus(StatusDto.StatusType.FAILURE);

			if (e instanceof UserServiceException) {
				e.printStackTrace();
				status.setMessage(e.getMessage());
			} else {
				e.printStackTrace();
				status.setMessage(e.getMessage());
			}
			return status;
		}

	}

}