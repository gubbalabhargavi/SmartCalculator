package com.savoira.w7;

/**
 * Notes comparing the time complexity of two approaches for common
 * banking operations at scale (1 million accounts).
 *
 * Scenario 1: Finding one account by ID
 * ---------------------------------------
 * Linear scan through a list: O(n) - in the worst case, every one of the
 * 1 million accounts must be checked before finding (or failing to find)
 * the target ID.
 *
 * HashMap lookup (keyed by account ID): O(1) average case - the hash
 * function computes the bucket directly, so lookup time does not grow
 * with the number of accounts.
 *
 * Choice for 1 million accounts: HashMap lookup. At this scale, O(n)
 * linear scan could mean checking up to a million entries per lookup,
 * while a HashMap lookup stays roughly constant time regardless of size.
 *
 *
 * Scenario 2: Finding all overdue accounts
 * ---------------------------------------
 * Nested loop (compare every pair): O(n^2) - for 1 million accounts,
 * this means up to 1 trillion comparisons, since every account is
 * compared against every other account.
 *
 * Single pass with a Set of overdue IDs: O(n) - each account is checked
 * once against the Set (itself an O(1) average lookup), so the total
 * work grows linearly with the number of accounts.
 *
 * Choice for 1 million accounts: single pass with a Set. O(n^2) at this
 * scale is computationally infeasible (1 trillion operations), while the
 * O(n) single-pass approach comfortably handles 1 million accounts.
 */
public class ComplexityNotes {

    public static void main(String[] args) {
        System.out.println("See the class-level comment above for the Big O analysis.");
    }
}