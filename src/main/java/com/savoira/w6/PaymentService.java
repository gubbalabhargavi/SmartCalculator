package com.savoira.w6;

/**
 * Represents Meridian Bank's payment service for a single account.
 * Enforces business rules on every payment attempt: amount must be
 * positive, must not exceed the daily transfer limit, and must not
 * exceed the current account balance.
 */
public class PaymentService {

    private static final double DAILY_LIMIT = 200000;

    private double balance;

    public PaymentService(double balance) {
        this.balance = balance;
    }

    /**
     * Processes a payment, deducting it from the balance if valid.
     *
     * @param amount the payment amount to process
     * @throws InvalidAmountException       if amount is zero or negative
     * @throws DailyLimitExceededException  if amount exceeds Rs.200,000
     * @throws InsufficientFundsException   if amount exceeds the current balance
     */
    public void processPayment(double amount) {
        if (amount <= 0) {
            throw new InvalidAmountException("Invalid payment amount: Rs." + amount + " must be greater than zero.");
        }

        if (amount > DAILY_LIMIT) {
            throw new DailyLimitExceededException(
                    "Payment of Rs." + amount + " exceeds the daily limit of Rs." + DAILY_LIMIT, amount);
        }

        if (amount > balance) {
            double shortfall = amount - balance;
            throw new InsufficientFundsException(
                    "Insufficient funds: payment of Rs." + amount + " exceeds balance of Rs." + balance
                            + ". Shortfall: Rs." + shortfall, shortfall);
        }

        balance -= amount;
        System.out.println("Payment of Rs." + amount + " processed. New balance: Rs." + balance);
    }

    public static void main(String[] args) {
        PaymentService service = new PaymentService(50000);

        double[] payments = {15000, -500, 250000, 40000, 10000};

        for (double amount : payments) {
            try {
                service.processPayment(amount);
            } catch (PaymentException e) {
                System.out.println("Error: " + e.getMessage());
            } finally {
                System.out.println("Attempt complete.");
            }
        }
    }
}