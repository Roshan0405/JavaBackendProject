package com.project.marprojectmodule.service;

import com.stripe.exception.StripeException;

public interface PaymentService {
    String makePayment(String orderId, long amount) throws StripeException;
}
