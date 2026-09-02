package com.savoira.assessment;

/**
 * Handles loan application eligibility checks for Meridian Retail Bank.
 */
public class LoanApplicationService {

    private static final double MIN_INCOME_RATIO = 0.10;
    private static final double MAX_LOAN_AMOUNT = 5_000_000;
    private static final int MIN_CREDIT_SCORE = 650;

    /**
     * Evaluates a loan application against income, amount, and credit score rules.
     *
     * @param income     the applicant's income
     * @param loanAmount the requested loan amount
     * @param creditScore the applicant's credit score
     * @return "APPROVED" if all checks pass
     * @throws InsufficientIncomeException          if income is too low for the loan amount
     * @throws InvalidLoanAmountException           if the loan amount is invalid
     * @throws CreditScoreBelowThresholdException   if the credit score is too low
     */
    public String applyForLoan(double income, double loanAmount, int creditScore) {

        if (loanAmount <= 0 || loanAmount > MAX_LOAN_AMOUNT) {
            throw new InvalidLoanAmountException("Invalid loan amount: Rs." + loanAmount);
        }

        double requiredIncome = loanAmount * MIN_INCOME_RATIO;
        if (income < requiredIncome) {
            double shortfall = requiredIncome - income;
            throw new InsufficientIncomeException(
                    "Insufficient income: Rs." + income + " is below the required Rs." + requiredIncome, shortfall);
        }

        if (creditScore < MIN_CREDIT_SCORE) {
            throw new CreditScoreBelowThresholdException(
                    "Credit score " + creditScore + " is below the minimum required " + MIN_CREDIT_SCORE);
        }

        return "APPROVED";
    }

    public static void main(String[] args) {
        LoanApplicationService service = new LoanApplicationService();

        System.out.println("----- Scenario 1: All checks pass -----");
        try {
            String result = service.applyForLoan(100000, 500000, 720);
            System.out.println("Result: " + result);
        } catch (LoanException e) {
            System.out.println("Rejected: " + e.getMessage());
        } finally {
            System.out.println("Application processed.");
        }

        System.out.println();
        System.out.println("----- Scenario 2: Income too low -----");
        try {
            String result = service.applyForLoan(20000, 500000, 720);
            System.out.println("Result: " + result);
        } catch (InsufficientIncomeException e) {
            System.out.println("Rejected: " + e.getMessage() + " (shortfall: Rs." + e.getShortfall() + ")");
        } finally {
            System.out.println("Application processed.");
        }

        System.out.println();
        System.out.println("----- Scenario 3: Invalid loan amount -----");
        try {
            String result = service.applyForLoan(100000, 6000000, 720);
            System.out.println("Result: " + result);
        } catch (InvalidLoanAmountException e) {
            System.out.println("Rejected: " + e.getMessage());
        } finally {
            System.out.println("Application processed.");
        }

        System.out.println();
        System.out.println("----- Scenario 4: Credit score too low -----");
        try {
            String result = service.applyForLoan(100000, 500000, 600);
            System.out.println("Result: " + result);
        } catch (CreditScoreBelowThresholdException e) {
            System.out.println("Rejected: " + e.getMessage());
        } finally {
            System.out.println("Application processed.");
        }
    }
}