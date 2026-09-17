package com.savoira.w6;

/**
 * Thrown when a payment amount exceeds the current account balance.
 * Stores the shortfall - how much more balance would have been needed.
 */
public class InsufficientFundsException extends PaymentException {

    private final double shortfall;

    public InsufficientFundsException(String message, double shortfall) {
        super(message);
        this.shortfall = shortfall;
    }

    /**
     * @return how much additional balance would have been needed to cover the payment
     */
    public double getShortfall() {
        return shortfall;
    }
}