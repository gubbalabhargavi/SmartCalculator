package com.savoira.assessment;

/**
 * Thrown when an applicant's income is insufficient for the requested loan amount.
 * Stores the shortfall - how much more income would have been needed.
 */
public class InsufficientIncomeException extends LoanException {

    private final double shortfall;

    public InsufficientIncomeException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    /**
     * @return the income shortfall (required income minus income provided)
     */
    public double getShortfall() {
        return shortfall;
    }
}