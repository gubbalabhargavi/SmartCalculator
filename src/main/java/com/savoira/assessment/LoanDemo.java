package com.savoira.assessment;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demonstrates the Loan hierarchy: polymorphism through a shared list,
 * interface references, and the equals/hashCode contract.
 */
public class LoanDemo {

    public static void main(String[] args) {

        List<Loan> loans = List.of(
                new HomeLoan("HL-1001", "Rahul Sharma", 3500000, 8.5, 240),
                new PersonalLoan("PL-2001", "Anita Desai", 200000, 12.0, 24),
                new EducationLoan("EL-3001", "Karan Mehta", 800000, 9.0, 60)
        );

        System.out.println("----- Loan Portfolio Summary (polymorphism) -----");
        for (Loan loan : loans) {
            loan.printSummary();
        }

        System.out.println();
        System.out.println("----- Auditable and Exportable interface references -----");
        Auditable a = new HomeLoan("HL-1001", "Rahul Sharma", 3500000, 8.5, 240);
        Exportable e = new HomeLoan("HL-1001", "Rahul Sharma", 3500000, 8.5, 240);
        System.out.println(a.getAuditLog());
        System.out.println(e.toCSVRow());

        System.out.println();
        System.out.println("----- equals() and hashCode() demo -----");
        Set<Loan> loanSet = new HashSet<>();
        loanSet.add(new HomeLoan("HL-9000", "First Applicant", 1000000, 9.0, 120));
        loanSet.add(new HomeLoan("hl-9000", "Different Applicant Name", 1000000, 9.0, 120));
        // Both loans have the same loanId (case-insensitive), so equals()/hashCode()
        // treat them as the same entry even though applicantName differs - the
        // HashSet correctly stores only one of them.
        System.out.println("HashSet size (should be 1): " + loanSet.size());
    }
}