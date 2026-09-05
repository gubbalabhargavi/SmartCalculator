package com.savoira.w7;

/**
 * Thrown when the withdrawal amount exceeds the maximum allowed (Rs.20,000).
 */
public class AboveMaximumException extends RuntimeException {
    public AboveMaximumException(String message) {
        super(message);
    }
}