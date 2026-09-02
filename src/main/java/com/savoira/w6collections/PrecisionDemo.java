package com.savoira.w6collections;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Demonstrates the floating-point precision problem with double arithmetic
 * and how BigDecimal solves it for financial calculations.
 */
public class PrecisionDemo {

    public static void main(String[] args) {

        System.out.println("----- The problem with double -----");
        double d1 = 0.1 + 0.2;
        System.out.println("0.1 + 0.2 using double = " + d1);

        System.out.println();
        System.out.println("----- The fix with BigDecimal -----");
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");
        System.out.println("0.1 + 0.2 using BigDecimal = " + bd1.add(bd2));

        System.out.println();
        System.out.println("----- Practical use: compound interest -----");
        // Loan of Rs.500,000 at 8.5% annual rate for 3 years, compounded monthly
        BigDecimal principal = new BigDecimal("500000");
        BigDecimal annualRate = new BigDecimal("8.5");
        BigDecimal monthlyRate = annualRate.divide(new BigDecimal("1200"), 10, RoundingMode.HALF_UP);
        int months = 3 * 12;

        BigDecimal onePlusRate = BigDecimal.ONE.add(monthlyRate);
        BigDecimal growthFactor = onePlusRate.pow(months);
        BigDecimal finalAmount = principal.multiply(growthFactor).setScale(2, RoundingMode.HALF_UP);

        System.out.println("Principal: Rs." + principal);
        System.out.println("Annual rate: " + annualRate + "%, compounded monthly for " + (months / 12) + " years");
        System.out.println("Final amount: Rs." + finalAmount);
    }
}