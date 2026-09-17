package com.savoira.assessment;

/**
 * Static utility class for common financial math calculations.
 * All methods are static, so this class is never meant to be instantiated.
 */
public class MathUtils {

    // prevent instantiation - utility class
    private MathUtils() {
    }

    /**
     * Rounds a value to two decimal places.
     *
     * @param v the value to round
     * @return v rounded to two decimal places
     */
    public static double roundToTwoDecimalPlaces(double v) {
        return Math.round(v * 100.0) / 100.0;
    }

    /**
     * Calculates simple interest.
     *
     * @param p the principal amount
     * @param r the annual interest rate, as a percentage (e.g. 10 for 10%)
     * @param t the time period, in years
     * @return the simple interest earned
     */
    public static double calculateSimpleInterest(double p, double r, double t) {
        return (p * r * t) / 100.0;
    }

    /**
     * Calculates compound interest.
     *
     * @param p the principal amount
     * @param r the annual interest rate, as a percentage (e.g. 10 for 10%)
     * @param n the number of times interest compounds per year
     * @param t the time period, in years
     * @return the total amount after compound interest (principal + interest)
     */
    public static double calculateCompoundInterest(double p, double r, int n, double t) {
        double amount = p * Math.pow(1 + (r / 100.0) / n, n * t);
        return roundToTwoDecimalPlaces(amount);
    }
}