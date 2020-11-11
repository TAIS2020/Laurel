package co.edu.javeriana.tais2020.laurel.payments.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.javeriana.tais2020.laurel.payments.entities.Payment;
import co.edu.javeriana.tais2020.laurel.payments.services.PaymentsService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentsController {

	@Autowired
	private PaymentsService paymentsService;

	@PostMapping
	public ResponseEntity<Payment> createPayment(@Valid @RequestBody Payment notification) {
		return ResponseEntity.ok(paymentsService.createPayment(notification));
	}

}
