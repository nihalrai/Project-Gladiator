package com.lti.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.PaymentDto;
import com.lti.entity.Customer;
import com.lti.entity.Payment;
import com.lti.exception.MakePaymentException;
import com.lti.repository.MakePaymentRepository;

@Service
public class MakePaymentServiceImpl implements MakePaymentService {
		
	@Autowired
	private MakePaymentRepository makePaymentRepository;
	
	@Override
    public Payment proceedPayment(PaymentDto paymentDto) {
        Payment newPayment = new Payment();
        String email = paymentDto.getEmail();
        
        if(makePaymentRepository.isUserValid(email)) {
        	Customer customer = makePaymentRepository.getCustomerByEmail(email);
        	//newPayment.setId(id);
        	newPayment.setAmount(paymentDto.getAmount());
        	newPayment.setDate(LocalDate.now());
        	newPayment.setMode(paymentDto.getModeOfPayment());
        	newPayment.setCustomer(customer);
        	makePaymentRepository.save(newPayment);
        }
        else throw new MakePaymentException("User not Valid. Payment Failed.");
        return newPayment;
    }
	
}
