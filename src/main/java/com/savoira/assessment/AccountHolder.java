package com.savoira.assessment;

/**
 * Immutability matters here because an AccountHolder represents identity
 * information tied to a real banking customer - their name, customer ID,
 * and email. Once this record is created, nothing in the rest of the
 * program should be able to silently change it (accidentally or maliciously),
 * since that could misdirect account statements, notifications, or KYC
 * records to the wrong person. Making all fields final with no setters
 * guarantees that once an AccountHolder object exists, its identity data
 * stays fixed and trustworthy for the lifetime of that object - if the
 * customer's details genuinely change, a new AccountHolder object should
 * be created instead of mutating the existing one.
 */
public class AccountHolder {

    private final String name;
    private final String customerId;
    private final String email;

    /**
     * Creates an immutable AccountHolder record.
     *
     * @param name       the customer's full name
     * @param customerId the unique customer identifier
     * @param email      the customer's email address
     */
    public AccountHolder(String name, String customerId, String email) {
        this.name = name;
        this.customerId = customerId;
        this.email = email;
    }

    /**
     * @return the customer's name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the customer's unique ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @return the customer's email address
     */
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "AccountHolder[name=" + name + ", customerId=" + customerId + ", email=" + email + "]";
    }

    public static void main(String[] args) {
        AccountHolder holder = new AccountHolder("Rohit Verma", "CUST-4521", "rohit.verma@example.com");
        System.out.println(holder.toString());
    }
}