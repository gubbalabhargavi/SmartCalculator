package com.savoira.assessment;

/**
 * Thrown when the requested loan amount is invalid - zero, negative,
 * or above the maximum allowed amount.
 */
public class InvalidLoanAmountException extends LoanException {
    public InvalidLoanAmountException(String message) {
        super(message);
    }
}