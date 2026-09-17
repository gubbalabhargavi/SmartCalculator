package com.savoira.assessment;

/**
 * Thrown when the applicant's credit score is below the minimum required threshold.
 */
public class CreditScoreBelowThresholdException extends LoanException {
    public CreditScoreBelowThresholdException(String message) {
        super(message);
    }
}