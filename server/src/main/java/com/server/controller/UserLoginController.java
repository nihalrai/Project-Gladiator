package com.server.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.exception.UserServiceException;
import com.server.dto.LoginStatusDto;
import com.server.dto.StatusDto;
import com.server.dto.LoginDto;
import com.server.entity.Customer;
import com.server.service.UserService;

@RestController
@CrossOrigin
public class UserLoginController {

	//@Autowired
	private UserService userService;

	@PostMapping(path = "/login", consumes = "application/json", produces = "application/json")
	public LoginStatusDto login(@RequestBody LoginDto loginDto) {

		try {
			//Implementatation
            Customer customer = userService.login(loginDto.getEmail(), loginDto.getPassword());
            
            LoginStatusDto status = new LoginStatusDto();
            status.setId(customer.getId());
            status.setName(customer.getName());
            status.setRole("USER");
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
    
    @PostMapping(path = "/admin/login", consumes = "application/json", produces = "application/json")
	public LoginStatusDto adminLogin(@RequestBody LoginDto loginDto) {

		try {
			//Implementatation
			Customer customer = userService.login(loginDto.getEmail(), loginDto.getPassword());
            LoginStatusDto status = new LoginStatusDto();
            status.setId(customer.getId());
            status.setName(customer.getName());
            status.setRole("ADMIN");
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