package com.savoira.assessment;

/**
 * Provides overloaded eligibility checks for loan applicants, with
 * progressively stricter criteria as more information is available.
 */
public class LoanCalculator {

    /**
     * Checks eligibility based on income alone.
     *
     * @param monthlyIncome the applicant's monthly income
     */
    public void assessEligibility(double monthlyIncome) {
        boolean eligible = monthlyIncome > 25000;
        System.out.println("Income-only check: " + (eligible ? "ELIGIBLE" : "NOT ELIGIBLE")
                + " (income = " + monthlyIncome + ")");
    }

    /**
     * Checks eligibility based on income minus existing EMI obligations.
     *
     * @param monthlyIncome the applicant's monthly income
     * @param existingEMI   the applicant's existing monthly EMI obligations
     */
    public void assessEligibility(double monthlyIncome, double existingEMI) {
        boolean eligible = (monthlyIncome - existingEMI) > 20000;
        System.out.println("Income + existing EMI check: " + (eligible ? "ELIGIBLE" : "NOT ELIGIBLE")
                + " (disposable income = " + (monthlyIncome - existingEMI) + ")");
    }

    /**
     * Checks eligibility based on income, existing EMI, and credit score.
     *
     * @param monthlyIncome the applicant's monthly income
     * @param existingEMI   the applicant's existing monthly EMI obligations
     * @param creditScore   the applicant's credit score
     */
    public void assessEligibility(double monthlyIncome, double existingEMI, int creditScore) {
        boolean incomeOk = (monthlyIncome - existingEMI) > 20000;
        boolean creditOk = creditScore > 650;
        boolean eligible = incomeOk && creditOk;
        System.out.println("Full check: " + (eligible ? "ELIGIBLE" : "NOT ELIGIBLE")
                + " (disposable income = " + (monthlyIncome - existingEMI) + ", creditScore = " + creditScore + ")");
    }

    public static void main(String[] args) {
        LoanCalculator calc = new LoanCalculator();

        System.out.println("----- Overload 1: income only -----");
        calc.assessEligibility(30000);

        System.out.println();
        System.out.println("----- Overload 2: income + existing EMI -----");
        calc.assessEligibility(45000, 20000);

        System.out.println();
        System.out.println("----- Overload 3: income + existing EMI + credit score -----");
        calc.assessEligibility(45000, 15000, 700);
    }
}