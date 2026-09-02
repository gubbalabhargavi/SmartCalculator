package com.savoira.assessment;

/**
 * Represents a home loan using the standard compound EMI formula.
 * Also supports audit logging and CSV export.
 */
public class HomeLoan extends Loan implements Auditable, Exportable {

    public HomeLoan(String id, String name, double principal, double rate, int tenure) {
        super(id, name, principal, rate, tenure);
    }

    @Override
    double calculateEMI() {
        double r = annualRate / 12 / 100;
        int n = tenureMonths;
        double factor = Math.pow(1 + r, n);
        return (principalAmount * r * factor) / (factor - 1);
    }

    @Override
    public String getAuditLog() {
        return getAuditPrefix() + "LoanId=" + loanId + " | Applicant=" + applicantName
                + " | Amount=" + principalAmount + " | Status=ACTIVE";
    }

    @Override
    public String toCSVRow() {
        return loanId + "," + applicantName + "," + principalAmount + "," + annualRate
                + "," + tenureMonths + "," + String.format("%.2f", calculateEMI());
    }
}