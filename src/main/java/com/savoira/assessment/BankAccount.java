package com.savoira.assessment;

/**
 * Represents a bank account with encapsulated state. All balance changes
 * go through deposit() or withdraw(), which validate input before
 * modifying the account.
 */
public class BankAccount {

    private final String accountNumber;
    private final String holderName;
    private double balance;
    private int transactionCount;

    /**
     * Primary constructor.
     *
     * @param accountNumber  the account number, set once and never changed
     * @param holderName     the name of the account holder
     * @param initialBalance the starting balance
     */
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
        this.transactionCount = 0;
    }

    /**
     * Overloaded constructor. Opens the account with a default balance of 0.0,
     * using constructor chaining to delegate to the primary constructor.
     *
     * @param accountNumber the account number
     * @param holderName    the name of the account holder
     */
    public BankAccount(String accountNumber, String holderName) {
        this(accountNumber, holderName, 0.0);
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
     * @return the number of successful deposits and withdrawals made on this account
     */
    public int getTransactionCount() {
        return transactionCount;
    }

    /**
     * @return a formatted summary of this account's current state
     */
    public String getSummary() {
        return "Account: " + accountNumber + " | Holder: " + holderName
                + " | Balance: Rs." + balance + " | Transactions: " + transactionCount;
    }

    public static void main(String[] args) {
        System.out.println("----- Creating Account 1 -----");
        BankAccount account1 = new BankAccount("2001", "Sanjay Kapoor", 10000);

        System.out.println("----- Creating Account 2 -----");
        BankAccount account2 = new BankAccount("2002", "Meera Nair");

        System.out.println();
        System.out.println("----- Account 1: operations -----");
        account1.deposit(2000);
        account1.withdraw(1500);

        System.out.println();
        System.out.println("----- Account 2: operations -----");
        account2.deposit(5000);
        account2.withdraw(2000);

        System.out.println();
        System.out.println("----- Invalid operation: negative withdrawal on Account 1 -----");
        account1.withdraw(-500);

        System.out.println();
        System.out.println("----- Final summaries -----");
        System.out.println(account1.getSummary());
        System.out.println(account2.getSummary());
    }
}