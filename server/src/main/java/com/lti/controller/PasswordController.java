package com.lti.controller;

import java.util.Map;

import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ForgotDto;
import com.lti.dto.ForgotPasswordStatus;
import com.lti.dto.OtpDto;
import com.lti.dto.StatusDto;
import com.lti.dto.StatusDto.StatusType;
import com.lti.dto.UpdateDto;
import com.lti.entity.User;
import com.lti.exception.UserServiceException;
import com.lti.service.EmailService;
import com.lti.service.UserService;

@RestController
@CrossOrigin
public class PasswordController {
	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping(path = "/forgotPassword", consumes = "application/json", produces = "application/json")
	public ForgotPasswordStatus forgotPassword(@RequestBody ForgotDto forgotDto) {
		System.out.println(forgotDto.getEmail());
		User user = userService.getUserByEmail(forgotDto.getEmail());
		
		try {
			if (!userService.isUserPresent(forgotDto.getEmail())) {
				throw new UserServiceException("User does not exists!");
			}

			String generatedOtp = UserService.generateOtp();
			if (generatedOtp == null) {
				throw new UserServiceException("OTP could not generated, try again!");
			}

			user.setOtp(generatedOtp);

			userService.addOrUpdateUser(user);

			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("nk.theraja@gmail.com"); // email of sender
			passwordResetEmail.setTo(forgotDto.getEmail());
			passwordResetEmail.setSubject("Reset your password");
			passwordResetEmail.setText("Your otp to reset password is " + generatedOtp);

			emailService.sendEmail(passwordResetEmail);

			ForgotPasswordStatus status = new ForgotPasswordStatus();
			status.setEmail(forgotDto.getEmail());
			status.setMessage("Otp for password reset is send to " + user.getEmailId());
			status.setStatus(StatusType.SUCCESS);

			return status;

		} catch (UserServiceException e) {
			ForgotPasswordStatus status = new ForgotPasswordStatus();
			status.setEmail(user.getEmailId());
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.FAILURE);

			return status;
		}
	}

	@PostMapping(path = "/verifyOtp", consumes = "application/json", produces = "application/json")
	public StatusDto verifyOtp(@RequestBody OtpDto otpDto) {
		try {
			User user = userService.getUserByOtp(otpDto.getOtp());
			if (user == null) {
				throw new UserServiceException("Invalid token");
			}
			StatusDto status = new StatusDto();
			status.setMessage("Otp is valid");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			
			return status;

		} catch (UserServiceException e) {
			StatusDto status = new StatusDto();
			status.setMessage(e.getMessage());
			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		} catch(NoResultException e) {
			StatusDto status = new StatusDto();
			status.setMessage("User does not exist with this otp!");
			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		}
	}
	
	@PostMapping(path = "/updatePassword", consumes = "application/json", produces = "application/json")  // emailId, oldPassword, newPassword
	public StatusDto updatePassword(@RequestBody UpdateDto reset) {
		try {
			User user = userService.getUserByEmail(reset.getEmail());
			
			if (user == null) {
				throw new UserServiceException("Unknown email address");
			}
			
			user.setPassword(UserService.getHashedString(reset.getNewPassword()));
			user.setOtp(null);
			
			userService.addOrUpdateUser(user);
			
			StatusDto status = new StatusDto();
			status.setMessage("Updated successfully!");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			
			return status;

		} catch (UserServiceException e) {
			StatusDto status = new StatusDto();
			status.setMessage(e.getMessage());
			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		}
	}
	
}
