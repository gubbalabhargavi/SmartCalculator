package com.savoira.assessment;

public class StringBuilderDemo {

    /**
     * Builds a single report string from an array of items, joined with " | ".
     *
     * @param items the items to include in the report
     * @return a formatted report string, e.g. "Report: item1 | item2 | item3"
     */
    public static String buildReport(String[] items) {
        StringBuilder sb = new StringBuilder("Report: ");
        for (int i = 0; i < items.length; i++) {
            sb.append(items[i]);
            if (i < items.length - 1) {
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] transactions = {
                "Salary Credit",
                "Grocery Debit",
                "Electricity Bill Payment",
                "ATM Withdrawal",
                "Fund Transfer to Savings"
        };

        System.out.println(buildReport(transactions));

        // StringBuilder is preferred over String concatenation inside a loop because
        // Strings in Java are immutable - every "+" concatenation creates a brand new
        // String object in memory and discards the old one, which gets very expensive
        // as the loop grows larger. StringBuilder instead uses a resizable internal
        // buffer that it modifies in place, so appending repeatedly in a loop is far
        // faster and uses significantly less memory.
    }
}