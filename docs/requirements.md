# Requirements — Loan Eligibility Checker

## C2.1 — Functional Requirements
1. The system shall allow the customer to input monthly income, existing loan amount, and requested loan amount.
2. The system shall calculate the debt-to-income ratio and compare it against the eligibility threshold.
3. The system shall display an eligibility result (Eligible / Not Eligible) along with the reason.
4. The system shall validate that all inputs are non-negative numbers and required fields are filled.
5. The system shall allow the customer to view or download a summary of the eligibility result.

## C2.2 — Non-Functional Requirements
1. **Performance**: The eligibility result must be returned within 2 seconds of submission.
2. **Security**: Customer financial data must be encrypted in transit (TLS) and at rest.
3. **Availability**: The feature must maintain 99.9% uptime during banking hours.

## C2.3 — Out of Scope
1. The feature will not process or submit the actual loan application/disbursement.
2. The feature will not factor in a credit bureau score in v1 — it uses only self-reported data.