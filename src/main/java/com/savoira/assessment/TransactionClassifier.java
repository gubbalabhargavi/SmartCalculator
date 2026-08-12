package com.savoira.assessment;

public class TransactionClassifier {

    /**
     * Classifies a bank transaction based on its type and amount.
     *
     * @param type   the transaction type: CREDIT, DEBIT, TRANSFER, or WITHDRAWAL
     * @param amount the transaction amount, used to distinguish large transfers
     * @return a human-readable classification of the transaction
     * @throws IllegalArgumentException if the type is not recognized
     */
    public static String classifyTransaction(String type, double amount) {
        return switch (type) {
            case "CREDIT" -> "Income - positive cash flow";
            case "DEBIT" -> "Expense - deducted from balance";
            case "TRANSFER" -> {
                if (amount > 10000) {
                    yield "Large Transfer - requires OTP";
                } else {
                    yield "Standard Transfer";
                }
            }
            case "WITHDRAWAL" -> "Cash Withdrawal";
            default -> throw new IllegalArgumentException("Unknown transaction type: " + type);
        };
    }

    public static void main(String[] args) {
        System.out.println(classifyTransaction("CREDIT", 5000));
        System.out.println(classifyTransaction("DEBIT", 1200));
        System.out.println(classifyTransaction("TRANSFER", 15000));
        System.out.println(classifyTransaction("TRANSFER", 3000));
        System.out.println(classifyTransaction("WITHDRAWAL", 2000));

        try {
            System.out.println(classifyTransaction("REFUND", 500));
        } catch (IllegalArgumentException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }
}