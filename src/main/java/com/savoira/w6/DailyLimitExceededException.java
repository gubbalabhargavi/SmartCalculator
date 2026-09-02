package com.savoira.w6;

/**
 * Thrown when a payment attempt exceeds the daily transfer limit of Rs.200,000.
 * Stores the amount that was attempted.
 */
public class DailyLimitExceededException extends PaymentException {

    private final double attemptedAmount;

    public DailyLimitExceededException(String message, double attemptedAmount) {
        super(message);
        this.attemptedAmount = attemptedAmount;
    }

    /**
     * @return the payment amount that was attempted and exceeded the daily limit
     */
    public double getAttemptedAmount() {
        return attemptedAmount;
    }
}