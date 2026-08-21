package com.savoira.w5;

/**
 * Represents a home loan, which uses the standard compound EMI formula.
 */
public class HomeLoan extends Loan implements Auditable {

    /**
     * Creates a new HomeLoan.
     *
     * @param loanId        the unique loan identifier
     * @param applicantName the name of the loan applicant
     * @param principal     the loan principal amount
     * @param annualRate    the annual interest rate, as a percentage
     * @param tenureMonths  the loan tenure, in months
     */
    public HomeLoan(String loanId, String applicantName, double principal, double annualRate, int tenureMonths) {
        super(loanId, applicantName, principal, annualRate, tenureMonths);
    }

    /**
     * Calculates EMI using the standard compound interest formula:
     * P x r x (1+r)^n / ((1+r)^n - 1), where r is the monthly rate
     * and n is the tenure in months.
     *
     * @return the calculated EMI amount
     */
    @Override
    public double calculateEMI() {
        double r = annualRate / 12 / 100;
        int n = tenureMonths;
        double factor = Math.pow(1 + r, n);
        return (principal * r * factor) / (factor - 1);
    }

    /**
     * @return the loan type label, "Home Loan"
     */
    @Override
    public String loanType() {
        return "Home Loan";
    }

    
    /**
     * @return an audit-formatted summary of this home loan
     */
    @Override
    public String auditSummary() {
        return auditPrefix() + loanId + " | " + applicantName + " | Rs." + principal + " | Rate:" + annualRate + "%";
    }
}