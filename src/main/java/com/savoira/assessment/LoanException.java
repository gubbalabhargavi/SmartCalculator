package com.savoira.assessment;

/**
 * Base exception for all loan application failures.
 */
public class LoanException extends RuntimeException {
    public LoanException(String message) {
        super(message);
    }
}