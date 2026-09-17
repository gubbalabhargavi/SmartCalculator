package com.savoira;

/**
 * Demonstrates BankAccount usage: creates two accounts, performs valid
 * deposits and withdrawals, attempts one invalid operation per account,
 * and prints the final state of both, along with static account tracking.
 */
public class Demo {

    public static void main(String[] args) {

        System.out.println("----- Creating Account 1 -----");
        var account1 = new BankAccount("1001", "Gubbala Bhargavi", 5000);

        System.out.println("----- Creating Account 2 -----");
        var account2 = new BankAccount("1002", "Ravi Kumar");

        System.out.println();
        System.out.println("----- Account 1: valid operations -----");
        account1.deposit(1500);
        account1.withdraw(2000);

        System.out.println();
        System.out.println("----- Account 1: invalid operation -----");
        account1.withdraw(100000);

        System.out.println();
        System.out.println("----- Account 2: valid operations -----");
        account2.deposit(3000);
        account2.withdraw(1000);

        System.out.println();
        System.out.println("----- Account 2: invalid operation -----");
        account2.deposit(-500);

        System.out.println();
        System.out.println("----- Final account states -----");
        System.out.println(account1.toString());
        System.out.println(account2.toString());

        System.out.println();
        System.out.println("----- Static tracking -----");
        var totalAccounts = BankAccount.getTotalAccountsCreated();
        System.out.println("Total BankAccount objects created so far: " + totalAccounts);

        System.out.println();
        System.out.println("----- LoanUtils demo -----");
        var loanUtils = new LoanUtils();
        var finalAmount = loanUtils.calculateCompoundInterest(100000, 12, 24);
        System.out.printf("Rs.100000 at 12%% annual interest for 24 months -> Rs.%.2f%n", finalAmount);
    }
}