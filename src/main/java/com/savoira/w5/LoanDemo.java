package com.savoira.w5;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Demonstrates the Loan class hierarchy, interfaces (Auditable, Exportable),
 * and the equals/hashCode contract.
 */
public class LoanDemo {

    public static void main(String[] args) {

        List<Loan> loans = List.of(
                new HomeLoan("HL-1001", "Rahul Sharma", 3500000, 8.5, 240),
                new PersonalLoan("PL-2001", "Anita Desai", 200000, 12.0, 24),
                new PersonalLoan("PL-2002", "Vikram Singh", 150000, 14.0, 12)
        );

        System.out.println("----- Loan Portfolio Summary -----");
        for (Loan loan : loans) {
            loan.printSummary();
        }

        System.out.println();
        System.out.println("----- Auditable demo -----");
        Auditable auditableLoan = new HomeLoan("HL-1001", "Rahul Sharma", 3500000, 8.5, 240);
        System.out.println(auditableLoan.auditSummary());

        System.out.println();
        System.out.println("----- Exportable demo -----");
        Exportable exportableLoan = new PersonalLoan("PL-2001", "Anita Desai", 200000, 12.0, 24);
        System.out.println(exportableLoan.toCSVRow());

        System.out.println();
        System.out.println("----- equals() and hashCode() demo -----");
        Set<Loan> loanSet = new HashSet<>();
        loanSet.add(new HomeLoan("HL-9000", "Test Applicant", 1000000, 9.0, 120));
        loanSet.add(new HomeLoan("hl-9000", "Test Applicant", 1000000, 9.0, 120));
        System.out.println("Added two HomeLoans with the same loanId (different case).");
        System.out.println("HashSet size (should be 1): " + loanSet.size());
    }
}