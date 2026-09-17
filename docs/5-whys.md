# 5 Whys — Customers Abandoning Loan Form at Step 2

**Problem**: Customers are abandoning the loan form on step 2 without completing it.

1. **Why?** Step 2 asks for information that feels overly detailed for a quick check.
2. **Why?** Step 2 requires uploading proof-of-income documents even for a preliminary eligibility check.
3. **Why?** The form reuses the same flow as the final loan application.
4. **Why?** No separate lightweight "quick check" flow was designed.
5. **Why?** The team didn't distinguish "eligibility check" (low friction) from "application" (high friction) during requirements/design.

**Root cause**: The Eligibility Checker inherited the full loan-application UX instead of being designed as its own low-friction flow.

**Actionable fix**: Redesign the eligibility check as a 2-field form (income, requested amount) with no document upload, and move document verification to a later, separate application step.