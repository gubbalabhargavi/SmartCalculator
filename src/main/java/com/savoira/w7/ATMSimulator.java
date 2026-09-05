package com.savoira.w7;

import java.util.Scanner;

/**
 * Simulates Meridian Bank's ATM withdrawal flow, enforcing all withdrawal
 * rules and giving the user up to 3 attempts before locking the card.
 */
public class ATMSimulator {

    private static final double MIN_WITHDRAWAL = 500;
    private static final double MAX_WITHDRAWAL = 20000;

    private double balance;

    public ATMSimulator(double balance) {
        this.balance = balance;
    }

    /**
     * Attempts to withdraw the given amount, enforcing all four rules.
     *
     * @param amount the amount to withdraw
     * @throws BelowMinimumException             if amount is less than Rs.500
     * @throws AboveMaximumException              if amount exceeds Rs.20,000
     * @throws NotMultipleOfFiveHundredException  if amount is not a multiple of Rs.500
     * @throws InsufficientBalanceException       if amount exceeds the current balance
     */
    public void withdraw(double amount) {
        if (amount < MIN_WITHDRAWAL) {
            throw new BelowMinimumException("Amount must be at least Rs." + MIN_WITHDRAWAL);
        }
        if (amount > MAX_WITHDRAWAL) {
            throw new AboveMaximumException("Amount cannot exceed Rs." + MAX_WITHDRAWAL);
        }
        if (amount % 500 != 0) {
            throw new NotMultipleOfFiveHundredException("Amount must be a multiple of Rs.500");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance. Current balance: Rs." + balance);
        }

        balance -= amount;
        System.out.println("Withdrawal successful. New balance: Rs." + balance);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ATMSimulator atm = new ATMSimulator(3000);

        int attempts = 0;
        int maxAttempts = 3;

        while (attempts < maxAttempts) {
            System.out.print("Enter withdrawal amount: ");
            double amount = Double.parseDouble(sc.nextLine().trim());

            try {
                atm.withdraw(amount);
                break;
            } catch (RuntimeException e) {
                attempts++;
                System.out.println("Error: " + e.getMessage());
                if (attempts >= maxAttempts) {
                    System.out.println("Card locked.");
                }
            }
        }
    }
}