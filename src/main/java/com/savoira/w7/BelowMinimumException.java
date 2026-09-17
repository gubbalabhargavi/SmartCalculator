package com.savoira.w7;

/**
 * Thrown when the withdrawal amount is below the minimum allowed (Rs.500).
 */
public class BelowMinimumException extends RuntimeException {
    public BelowMinimumException(String message) {
        super(message);
    }
}