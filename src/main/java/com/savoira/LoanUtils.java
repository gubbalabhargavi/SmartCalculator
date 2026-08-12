package com.savoira;

/**
 * Utility class for loan and interest-related calculations.
 *
 * The original dirty version of this method violated five clean-code rules:
 * 1. Non-descriptive method name ("calc" gives no indication of what it computes).
 * 2. Non-descriptive parameter names ("a", "b", "c" instead of meaningful names).
 * 3. Magic number (1200 used with no explanation of where it comes from).
 * 4. Poor formatting (no spacing around operators, everything on one line).
 * 5. No documentation (no comment explaining the formula or parameters).
 */
public class LoanUtils {

    /** Number of months in a year, used to convert an annual rate to a monthly rate. */
    private static final int MONTHS_IN_YEAR = 12;

    /** Used to convert a percentage rate into a decimal fraction. */
    private static final int PERCENTAGE_DIVISOR = 100;

    /**
     * Calculates the final amount after applying monthly compound interest.
     *
     * @param principal          the starting principal amount
     * @param annualInterestRate the annual interest rate, as a percentage (e.g. 12 for 12%)
     * @param months             the number of months the interest compounds for
     * @return the final amount after compound interest has been applied
     */
    public double calculateCompoundInterest(double principal, double annualInterestRate, int months) {
        double monthlyRate = annualInterestRate / (PERCENTAGE_DIVISOR * MONTHS_IN_YEAR);
        double growthFactor = 1;

        for (int month = 0; month < months; month++) {
            growthFactor = growthFactor * (1 + monthlyRate);
        }

        return principal * growthFactor;
    }
}