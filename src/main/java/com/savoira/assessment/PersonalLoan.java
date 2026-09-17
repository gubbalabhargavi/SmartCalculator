package com.savoira.assessment;

/**
 * Represents a personal loan using flat-rate simple interest.
 */
public class PersonalLoan extends Loan {

    public PersonalLoan(String id, String name, double principal, double rate, int tenure) {
        super(id, name, principal, rate, tenure);
    }

    @Override
    double calculateEMI() {
        double totalInterest = principalAmount * (annualRate / 100) * ((double) tenureMonths / 12);
        double totalPayable = principalAmount + totalInterest;
        return totalPayable / tenureMonths;
    }
}