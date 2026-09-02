package com.savoira.assessment;

/**
 * Represents an education loan. Uses the same flat-rate simple interest
 * formula as PersonalLoan, but adds a 6-month moratorium period - the
 * total repayable amount includes 6 extra months of simple interest
 * accrued during the moratorium, before EMI payments begin.
 */
public class EducationLoan extends Loan {

    private static final int MORATORIUM_MONTHS = 6;

    public EducationLoan(String id, String name, double principal, double rate, int tenure) {
        super(id, name, principal, rate, tenure);
    }

    @Override
    double calculateEMI() {
        double totalInterest = principalAmount * (annualRate / 100) * ((double) tenureMonths / 12);
        double totalPayable = principalAmount + totalInterest;
        return totalPayable / tenureMonths;
    }

    /**
     * Adds 6 months of simple interest on top of the base total repayable,
     * accrued during the moratorium period before repayments begin.
     *
     * @return the total repayable amount including moratorium interest
     */
    @Override
    double totalRepayable() {
        double baseTotal = calculateEMI() * tenureMonths;
        double moratoriumInterest = principalAmount * (annualRate / 100) * ((double) MORATORIUM_MONTHS / 12);
        return baseTotal + moratoriumInterest;
    }
}