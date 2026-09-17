package com.savoira.w7;

/**
 * Contains the corrected version of findLargest(), which originally had
 * two bugs: an incorrect initial value for max, and an off-by-one error
 * in the loop bound.
 */
public class BugFixer {

    static double findLargest(double[] amounts) {
        // Bug 1 fix: initializing max to 0 assumes the largest value is
        // never negative. If all elements in the array are negative, the
        // original code would incorrectly return 0 instead of the true
        // (negative) maximum. Fixing this by initializing max to the
        // array's first element instead of a hardcoded 0.
        double max = amounts[0];

        // Bug 2 fix: the loop condition used "i <= amounts.length", which
        // allows i to reach amounts.length itself - one index past the
        // last valid element (valid indices are 0 to length-1). This
        // caused an ArrayIndexOutOfBoundsException. Changed to "<" so the
        // loop stops at the last valid index.
        for (int i = 0; i < amounts.length; i++) {
            if (amounts[i] > max) max = amounts[i];
        }
        return max;
    }

    public static void main(String[] args) {
        double[] amounts = {1500, 500, 20000, 300, 8000};
        System.out.println("Largest amount: " + findLargest(amounts));

        double[] negativeAmounts = {-500, -1200, -300};
        System.out.println("Largest of all-negative array: " + findLargest(negativeAmounts));
    }
}