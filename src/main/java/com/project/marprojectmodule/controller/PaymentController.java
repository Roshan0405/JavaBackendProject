package com.project.marprojectmodule.controller;

import com.project.marprojectmodule.dto.PaymentRequestDto; // Adjust package if needed
import com.project.marprojectmodule.service.PaymentService;
import com.stripe.exception.StripeException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


//    @PostMapping("/payments")
//    public <PaymentRequestDto> ResponseEntity<String> createPaymentLink(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
//        // It should get the order details from order service
//        String paymentLink  = paymentService.makePayment(paymentRequestDto.getOrderId(),
//                paymentRequestDto.getAmount());
//        return new ResponseEntity<>(paymentLink, HttpStatus.OK);
//
//    }

    @PostMapping("/payments")
    public ResponseEntity<String> createPaymentLink(@RequestBody PaymentRequestDto paymentRequestDto) throws StripeException {
//        System.out.println("Received Order ID: " + paymentRequestDto.getOrderId());
//        System.out.println("Received Amount: " + paymentRequestDto.getAmount());

        String paymentLink = paymentService.makePayment(paymentRequestDto.getOrderId(), paymentRequestDto.getAmount());
        return new ResponseEntity<>(paymentLink, HttpStatus.OK);
    }

    @PostMapping("/webhook")
    public void handleWebhook() {
        System.out.println("Webhook revecied here");
    }

}
