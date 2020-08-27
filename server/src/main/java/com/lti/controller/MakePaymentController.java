package com.lti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.PaymentDto;
import com.lti.entity.Payment;
import com.lti.exception.MakePaymentException;
import com.lti.service.MakePaymentServiceImpl;

@RestController
@CrossOrigin
public class MakePaymentController {
	
	@Autowired
	private MakePaymentServiceImpl makePaymentService;
	
	@PostMapping(path = "/payment", consumes = "application/json" , produces = "application/json")
	public Payment makePaymentNow(@RequestBody PaymentDto paymentDto) {
		Payment payment = new Payment();
		try {
			payment = makePaymentService.proceedPayment(paymentDto);
		}
		catch(MakePaymentException e) {
			System.out.println(e.getMessage());
		}
		
		return payment;
	}
}
