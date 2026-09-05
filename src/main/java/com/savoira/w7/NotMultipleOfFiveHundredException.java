package com.savoira.w7;

/**
 * Thrown when the withdrawal amount is not a multiple of Rs.500.
 */
public class NotMultipleOfFiveHundredException extends RuntimeException {
    public NotMultipleOfFiveHundredException(String message) {
        super(message);
    }
}