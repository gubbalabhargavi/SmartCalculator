# Code Review - transfer() method

## Original method

```java
public void transfer(String from, String to, double amt) {
    try {
        accounts.get(from).setBalance(accounts.get(from).getBalance() - amt);
        accounts.get(to).setBalance(accounts.get(to).getBalance() + amt);
    } catch (Exception e) {
        // ignore
    }
}
```

## Problems found

1. **Blocker - silently swallowed exception.** The catch block is empty. If either
   account ID doesn't exist, `accounts.get(...)` returns null and the next line
   throws a NullPointerException that vanishes silently - the caller has no idea
   the transfer failed.

2. **Blocker - not atomic, risk of losing money.** If the deduction from `from`
   succeeds but crediting `to` fails afterward, the amount has been deducted but
   never credited anywhere - money effectively disappears from the ledger.

3. **Major - no validation of the amount.** There is no check that `amt` is
   positive. A negative or zero amount could be used to illegally reverse a
   transfer or create funds from nothing.

4. **Major - catches overly broad Exception type.** Catching `Exception` instead
   of a specific type hides real, unrelated bugs alongside expected failure
   cases, making the code very hard to debug.

## Corrected method

```java
public void transfer(String from, String to, double amt) {
    if (amt <= 0) {
        throw new IllegalArgumentException("Transfer amount must be positive: " + amt);
    }

    Account fromAccount = accounts.get(from);
    Account toAccount = accounts.get(to);

    if (fromAccount == null) {
        throw new NoSuchElementException("Source account not found: " + from);
    }
    if (toAccount == null) {
        throw new NoSuchElementException("Destination account not found: " + to);
    }
    if (fromAccount.getBalance() < amt) {
        throw new IllegalStateException("Insufficient balance in account: " + from);
    }

    fromAccount.setBalance(fromAccount.getBalance() - amt);
    toAccount.setBalance(toAccount.getBalance() + amt);
}
```

## Explanation of the fix

- Validates `amt` is positive before doing anything.
- Looks up both accounts once, checks each for null explicitly, and throws a
  specific, descriptive exception instead of silently failing.
- Checks the source account has enough balance before attempting the deduction,
  preventing the two-step operation from partially completing and losing money.
- No more empty catch block - callers can now catch specific exceptions
  (`IllegalArgumentException`, `NoSuchElementException`, `IllegalStateException`)
  and respond appropriately, instead of failures disappearing silently.