package com.savoira.w6;

/**
 * Base exception for all payment-related failures in Meridian Bank's
 * payment service.
 */
public class PaymentException extends RuntimeException {
    public PaymentException(String message) {
        super(message);
    }
}