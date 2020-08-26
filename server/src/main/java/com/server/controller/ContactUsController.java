package com.server.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.server.dto.ContactUsDto;
import com.server.dto.LoginDto;
import com.server.dto.LoginStatusDto;
import com.server.dto.StatusDto;
import com.server.entity.User;
import com.server.exception.UserServiceException;
import com.server.service.EmailService;

@RestController
@CrossOrigin
public class ContactUsController {
	@Autowired
	private EmailService emailService;
	
	@PostMapping(path = "/contactUs", consumes = "application/json", produces = "application/json")
	public StatusDto login(@RequestBody ContactUsDto contactUsDto) {
		try {

			SimpleMailMessage registeredMail = new SimpleMailMessage();
			registeredMail.setFrom(contactUsDto.getEmailId()); // email of sender
			registeredMail.setTo("niihalrai@gmail.com");   //server email address
			registeredMail.setSubject(contactUsDto.getSubject());
			registeredMail.setText(contactUsDto.getMessage());

			emailService.sendEmail(registeredMail);
			
			StatusDto status = new StatusDto();
			status.setMessage("Sent successfully!");
			status.setStatus(StatusDto.StatusType.SUCCESS);
			return status;
		} catch (MailException e) {
			StatusDto status = new StatusDto();
			status.setMessage("Error occured during sending email!");
			status.setStatus(StatusDto.StatusType.FAILURE);
			return status;
		}
	}

}
