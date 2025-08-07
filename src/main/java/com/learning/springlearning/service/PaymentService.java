package com.learning.springlearning.service;

import com.learning.springlearning.exception.NotEnoughMoneyException;
import com.learning.springlearning.model.PaymentDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	public PaymentDetails processPayment(){
		throw new NotEnoughMoneyException();
	}
}
