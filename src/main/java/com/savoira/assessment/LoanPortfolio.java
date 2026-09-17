package com.savoira.assessment;

import java.util.*;

/**
 * Manages a portfolio of loans using List, Map, and Set together for
 * different purposes: ordered storage, fast lookup, and uniqueness tracking.
 */
public class LoanPortfolio {

    public static void main(String[] args) {

        // List: ordered storage of all loans
        List<Loan> loanList = new ArrayList<>();
        loanList.add(new HomeLoan("HL-1001", "Rahul Sharma", 3500000, 8.5, 240));
        loanList.add(new PersonalLoan("PL-2001", "Anita Desai", 200000, 12.0, 24));
        loanList.add(new EducationLoan("EL-3001", "Rahul Sharma", 800000, 9.0, 60));

        // Map: fast lookup by loanId
        Map<String, Loan> loanMap = new HashMap<>();
        for (Loan loan : loanList) {
            loanMap.put(loan.loanId, loan);
        }

        // Set: unique applicant names
        Set<String> uniqueApplicants = new HashSet<>();
        for (Loan loan : loanList) {
            uniqueApplicants.add(loan.applicantName);
        }

        System.out.println("----- D1.1: List - all loans -----");
        for (Loan loan : loanList) {
            loan.printSummary();
        }

        System.out.println();
        System.out.println("----- D1.2: Map lookup -----");
        Loan found = loanMap.get("PL-2001");
        System.out.println("Successful lookup PL-2001: " + (found != null ? found.applicantName : "not found"));
        Loan notFound = loanMap.get("XX-9999");
        System.out.println("Failed lookup XX-9999: " + (notFound != null ? notFound.applicantName : "not found"));

        System.out.println();
        System.out.println("----- D1.3: Set - unique applicant count -----");
        System.out.println("Unique applicants: " + uniqueApplicants.size() + " " + uniqueApplicants);

        System.out.println();
        System.out.println("----- D1.4: Iteration - for-each -----");
        for (Loan loan : loanList) {
            System.out.println(loan.loanId);
        }

        System.out.println();
        System.out.println("----- D1.4: Iteration - Iterator -----");
        Iterator<Loan> it = loanList.iterator();
        while (it.hasNext()) {
            Loan loan = it.next();
            System.out.println(loan.loanId);
        }
    }
}