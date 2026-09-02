package com.savoira.w6;

/**
 * Thrown when a payment amount is invalid (zero or negative).
 */
public class InvalidAmountException extends PaymentException {
    public InvalidAmountException(String message) {
        super(message);
    }
}