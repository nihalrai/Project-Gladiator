package com.lti.service;

import com.lti.dto.PaymentDto;
import com.lti.entity.Payment;

public interface MakePaymentService {

	Payment proceedPayment(PaymentDto paymentDto);

}