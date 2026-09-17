package com.savoira.w5;

/**
 * Represents a personal loan, which uses flat-rate simple interest.
 */
public class PersonalLoan extends Loan {

    /**
     * Creates a new PersonalLoan.
     *
     * @param loanId        the unique loan identifier
     * @param applicantName the name of the loan applicant
     * @param principal     the loan principal amount
     * @param annualRate    the annual interest rate, as a percentage
     * @param tenureMonths  the loan tenure, in months
     */
    public PersonalLoan(String loanId, String applicantName, double principal, double annualRate, int tenureMonths) {
        super(loanId, applicantName, principal, annualRate, tenureMonths);
    }

    /**
     * Calculates EMI using flat-rate simple interest:
     * (principal + principal x annualRate/100 x tenureMonths/12) / tenureMonths.
     *
     * @return the calculated EMI amount
     */
    @Override
    public double calculateEMI() {
        double totalInterest = principal * (annualRate / 100) * ((double) tenureMonths / 12);
        double totalPayable = principal + totalInterest;
        return totalPayable / tenureMonths;
    }

    /**
     * @return the loan type label, "Personal Loan"
     */
    @Override
    public String loanType() {
        return "Personal Loan";
    }
}