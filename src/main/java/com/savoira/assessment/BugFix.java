package com.savoira.assessment;

/**
 * Contains the original buggy sumEvens() and a corrected version,
 * demonstrating the fix for both bugs.
 */
public class BugFix {

    /**
     * Original buggy version - kept here only to show both outputs side by side.
     */
    public static int sumEvensBuggy(int n) {
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1)
                sum += i;
        }
        return sum;
    }

    /**
     * Corrected version: sum starts at 0 (the correct identity for addition),
     * and the condition checks for even numbers (i % 2 == 0) instead of odd.
     */
    public static int sumEvensFixed(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                sum += i;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Buggy sumEvens(10): " + sumEvensBuggy(10));
        System.out.println("Fixed sumEvens(10): " + sumEvensFixed(10));
    }
}