package com.savoira.assessment;

public class BelowMinimumException extends RuntimeException {
    public BelowMinimumException(String message) {
        super(message);
    }
}