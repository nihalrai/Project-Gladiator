package com.server.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.server.dto.ForgotPasswordStatus;
import com.server.dto.StatusDto.StatusType;
import com.server.dto.UserPasswordDto;

import com.server.entity.User;
import com.server.exception.UserServiceException;
import com.server.service.EmailService;
import com.server.service.UserService;

@RestController
@CrossOrigin
public class PasswordController {
	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping(path = "/forgotPassword", consumes = "application/json", produces = "application/json")
	public ForgotPasswordStatus forgotPassword(@RequestBody UserPasswordDto userPasswordDto) {

		User user = userService.getUserByEmail(userPasswordDto.getEmail());

		try {
			if (!userService.isUserPresent(userPasswordDto.getEmail())) {
				throw new UserServiceException("User does not exists!");
			}

			user.setResetToken(UUID.randomUUID().toString());

			userService.addOrUpdateUser(user);

			String resetUrl = "http://localhost:8080/resetPassword?token=" + user.getResetToken();

			SimpleMailMessage passwordResetEmail = new SimpleMailMessage();
			passwordResetEmail.setFrom("noreply@noreply.com"); // email of sender
			passwordResetEmail.setTo(user.getEmailId());
			passwordResetEmail.setSubject("Reset your password");
			passwordResetEmail.setText("Reset password using below link :\n" + resetUrl);

			emailService.sendEmail(passwordResetEmail);

			ForgotPasswordStatus status = new ForgotPasswordStatus();
			status.setEmail(user.getEmailId());
			status.setMessage("Password reset link is send to " + user.getEmailId());
			status.setStatus(StatusType.SUCCESS);

			return status;

		} catch (Exception e) {
			ForgotPasswordStatus status = new ForgotPasswordStatus();
			status.setEmail(user.getEmailId());
			status.setMessage(e.getMessage());
			status.setStatus(StatusType.SUCCESS);

			return status;
		}

	}

	@GetMapping(path = "/resetPassword")
	public String forgotPassword(@RequestParam("token") String token) {
		try {
			User user = userService.getUserByResetToken(token);
			if (user == null) {
				throw new UserServiceException("Invalid token");
			}

			else {
				return "reset";
			}
		} catch (Exception e) {
			return null;
		}
	}
}
