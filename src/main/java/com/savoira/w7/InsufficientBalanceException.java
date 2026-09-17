package com.savoira.w7;

/**
 * Thrown when the withdrawal amount exceeds the current account balance.
 */
public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}