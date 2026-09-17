package com.savoira.w5;

import java.util.List;

/**
 * Demonstrates the Loan class hierarchy and runtime polymorphism by
 * storing different loan types in a single List<Loan> and printing
 * each one through the same shared loop.
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
            // Even though the variable is declared as type Loan, calling
            // printSummary() here triggers HomeLoan's or PersonalLoan's
            // own calculateEMI() and loanType(), decided at runtime based
            // on the actual object - this is runtime polymorphism.
            loan.printSummary();
        }
    }
}