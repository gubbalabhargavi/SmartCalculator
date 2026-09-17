package com.savoira.assessment;

/**
 * Abstract base class for all Meridian Retail Bank loan products.
 * Each concrete loan type defines its own EMI calculation, but shares
 * the total repayable and summary printing logic.
 */
public abstract class Loan {

    protected final String loanId;
    protected final String applicantName;
    protected final double principalAmount;
    protected final double annualRate;
    protected final int tenureMonths;

    public Loan(String id, String name, double principal, double rate, int tenure) {
        this.loanId = id;
        this.applicantName = name;
        this.principalAmount = principal;
        this.annualRate = rate;
        this.tenureMonths = tenure;
    }

    /**
     * Calculates the EMI for this loan. Each loan type applies its own formula.
     *
     * @return the calculated EMI
     */
    abstract double calculateEMI();

    /**
     * @return the total amount repayable over the loan's tenure
     */
    double totalRepayable() {
        return calculateEMI() * tenureMonths;
    }

    /**
     * Prints a formatted summary of this loan, including its EMI and
     * total repayable amount.
     */
    void printSummary() {
        System.out.printf(
                "LoanId: %s | Applicant: %s | Principal: %.2f | Rate: %.2f%% | Tenure: %d months | EMI: %.2f | Total Repayable: %.2f%n",
                loanId, applicantName, principalAmount, annualRate, tenureMonths, calculateEMI(), totalRepayable());
    }

    /**
     * Two Loan objects are considered equal if and only if their loanId
     * values match, ignoring case - regardless of subclass type or any
     * other field differences (e.g. applicant name).
     *
     * @param obj the object to compare against
     * @return true if obj is a Loan with the same loanId (case-insensitive)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Loan)) {
            return false;
        }
        Loan other = (Loan) obj;
        return this.loanId != null && this.loanId.equalsIgnoreCase(other.loanId);
    }

    /**
     * Generates a hash code consistent with equals() - based on the
     * lowercase form of loanId, so two equal loans always produce the
     * same hash code, as required by the equals/hashCode contract.
     *
     * @return the hash code for this loan
     */
    @Override
    public int hashCode() {
        return loanId == null ? 0 : loanId.toLowerCase().hashCode();
    }
}