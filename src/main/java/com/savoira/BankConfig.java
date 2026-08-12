package com.savoira;

/**
 * Holds shared configuration constants used across the banking application.
 * These values are the same for every account, so they are defined once
 * here as static final fields rather than duplicated in each object.
 */
public class BankConfig {

    /** Maximum amount allowed in a single deposit. */
    public static final double MAX_DEPOSIT = 500_000.0;

    /** Maximum amount allowed in a single withdrawal. */
    public static final double MAX_WITHDRAWAL = 200_000.0;

    /** Maximum number of transactions allowed per account per day. */
    public static final int MAX_DAILY_TXN = 10;
}