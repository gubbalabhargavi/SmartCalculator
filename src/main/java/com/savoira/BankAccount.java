package com.savoira;

/**
 * Represents a bank account with encapsulated state.
 * All balance-changing operations go through deposit() or withdraw(),
 * which enforce business rules so the balance can never become invalid.
 */
public class BankAccount {

    private String accountNumber;
    private String holderName;
    private double balance;
    private int transactionCount;

    /**
     * Primary constructor.
     *
     * @param accountNumber  the account number
     * @param holderName     the name of the account holder
     * @param initialBalance the starting balance; must not be negative
     */
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = (initialBalance >= 0) ? initialBalance : 0;
        this.transactionCount = 0;
    }

    /**
     * Overloaded constructor for opening an account with zero balance.
     *
     * @param accountNumber the account number
     * @param holderName    the name of the account holder
     */
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0);
    }

    /**
     * Deposits money into the account. Rejects the operation if the
     * amount is not positive.
     *
     * @param amount the amount to deposit; must be greater than 0
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit: amount must be greater than 0.");
            return;
        }
        balance += amount;
        transactionCount++;
        System.out.println("Deposited Rs." + amount + " successfully.");
    }

    /**
     * Withdraws money from the account. Rejects the operation if the
     * amount is not positive, or if it exceeds the current balance.
     *
     * @param amount the amount to withdraw; must be greater than 0 and
     *               not exceed the current balance
     */
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal: amount must be greater than 0.");
            return;
        }
        if (amount > balance) {
            System.out.println("Invalid withdrawal: insufficient balance.");
            return;
        }
        balance -= amount;
        transactionCount++;
        System.out.println("Withdrew Rs." + amount + " successfully.");
    }

    /**
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * @return the account holder's name
     */
    public String getHolderName() {
        return holderName;
    }

    /**
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * @return the number of successful transactions on this account
     */
    public int getTransactionCount() {
        return transactionCount;
    }

    /**
     * @return a formatted summary of this account's state
     */
    @Override
    public String toString() {
        return "ACC" + accountNumber + " | " + holderName + " | Balance: Rs." + balance + " | Txn: " + transactionCount;
    }
}