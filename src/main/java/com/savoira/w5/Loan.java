package com.savoira.w5;

/**
 * Represents a bank loan product. Concrete subclasses must define how
 * their EMI is calculated and what type of loan they are.
 */
public abstract class Loan {

    protected String loanId;
    protected String applicantName;
    protected double principal;
    protected double annualRate;
    protected int tenureMonths;

    /**
     * Creates a new Loan.
     *
     * @param loanId        the unique loan identifier
     * @param applicantName the name of the loan applicant
     * @param principal     the loan principal amount
     * @param annualRate    the annual interest rate, as a percentage (e.g. 8.5 for 8.5%)
     * @param tenureMonths  the loan tenure, in months
     */
    public Loan(String loanId, String applicantName, double principal, double annualRate, int tenureMonths) {
        this.loanId = loanId;
        this.applicantName = applicantName;
        this.principal = principal;
        this.annualRate = annualRate;
        this.tenureMonths = tenureMonths;
    }

    /**
     * Calculates the equated monthly installment (EMI) for this loan.
     * Each loan type applies its own interest formula.
     *
     * @return the calculated EMI amount
     */
    public abstract double calculateEMI();

    /**
     * @return a short label identifying the type of this loan, e.g. "Home Loan"
     */
    public abstract String loanType();

    /**
     * Prints a formatted summary of this loan, including its type and EMI.
     * Calling this on a Loan reference demonstrates runtime polymorphism,
     * since calculateEMI() and loanType() resolve to the actual object's class.
     */
    public void printSummary() {
        System.out.printf(
                "[%s] %s | Applicant: %s | Principal: %.2f | Rate: %.2f%% | Tenure: %d months | EMI: %.2f%n",
                loanType(), loanId, applicantName, principal, annualRate, tenureMonths, calculateEMI());
    }
}