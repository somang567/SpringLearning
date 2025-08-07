package com.learning.springlearning.controller;

import com.learning.springlearning.exception.NotEnoughMoneyException;
import com.learning.springlearning.model.ErrorDetails;
import com.learning.springlearning.model.PaymentDetails;
import com.learning.springlearning.service.PaymentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
	private final PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	@PostMapping("/payment")
	public ResponseEntity<?> makePayment(){
		try{
			PaymentDetails paymentDetails = paymentService.processPayment();

			return ResponseEntity
					.status(HttpStatus.ACCEPTED)
					.body(paymentDetails);
		} catch (NotEnoughMoneyException e){
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setErrorMessage("Not Enough Money to make the  payment");
			return ResponseEntity
					.badRequest().body(errorDetails);
		}
	}
}
