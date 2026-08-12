package com.savoira.assessment;

public class AccountFormatter {

    /**
     * Formats an account summary string with the holder's name in uppercase
     * and the balance shown to exactly two decimal places.
     *
     * @param name        the account holder's name
     * @param balance     the account balance
     * @param accountType the type of account, e.g. "SAVINGS"
     * @return a formatted summary string
     */
    public static String formatAccountSummary(String name, double balance, String accountType) {
        String upperName = name.toUpperCase();
        String formattedBalance = String.format("%.2f", balance);
        return "Account Holder: " + upperName + " | Type: " + accountType + " | Balance: \u20B9" + formattedBalance;
    }

    public static void main(String[] args) {
        System.out.println(formatAccountSummary("Priya Sharma", 45200.50, "SAVINGS"));
        System.out.println(formatAccountSummary("Arjun Mehta", 120000, "CURRENT"));
        System.out.println(formatAccountSummary("Divya Rao", 875.5, "SAVINGS"));
    }
}