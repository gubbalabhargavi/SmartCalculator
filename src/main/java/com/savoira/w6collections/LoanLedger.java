package com.savoira.w6collections;

import java.util.*;

/**
 * An in-memory ledger of loan accounts, demonstrating List, Map, and Set
 * used together for different purposes on the same data.
 */
public class LoanLedger {

    /**
     * Represents a single account entry in the ledger.
     */
    static class Account {
        String accountId;
        String holderName;
        double balance;
        boolean active;

        Account(String accountId, String holderName, double balance, boolean active) {
            this.accountId = accountId;
            this.holderName = holderName;
            this.balance = balance;
            this.active = active;
        }
    }

    public static void main(String[] args) {

        // List: preserves insertion order, holds every account
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account("ACC001", "Rahul Sharma", 45000, true));
        accountList.add(new Account("ACC002", "Anita Desai", 120000, true));
        accountList.add(new Account("ACC003", "Vikram Singh", 0, false));

        // Map: fast lookup by accountId, built from the list
        Map<String, Account> accountMap = new HashMap<>();
        for (Account acc : accountList) {
            accountMap.put(acc.accountId, acc);
        }

        // Set: tracks unique active account IDs
        Set<String> activeAccountIds = new HashSet<>();
        for (Account acc : accountList) {
            if (acc.active) {
                activeAccountIds.add(acc.accountId);
            }
        }

        System.out.println("----- Balance per account (List) -----");
        for (Account acc : accountList) {
            System.out.printf("%s | %s | Rs.%.2f | Active: %b%n",
                    acc.accountId, acc.holderName, acc.balance, acc.active);
        }

        System.out.println();
        System.out.println("----- Fast lookup (Map) -----");
        Account lookup = accountMap.get("ACC002");
        System.out.println("Lookup ACC002: " + lookup.holderName + ", Rs." + lookup.balance);

        System.out.println();
        System.out.println("----- Active account count (Set) -----");
        System.out.println("Active accounts: " + activeAccountIds.size());
    }
}