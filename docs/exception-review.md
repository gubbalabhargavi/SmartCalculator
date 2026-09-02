# Code Review - processPayment() (Assessment 3, Task D2)

## Original method

```java
public void processPayment(double amount) {
    try {
        if (amount <= 0) throw new Exception("bad");
        // deduct from account
    } catch (Exception e) {
        // silent
    }
}
```

## Problems found

1. **Blocker - throws a checked Exception with a meaningless message.** `throw new Exception("bad")`
   gives the caller zero context about what actually went wrong - "bad" describes nothing.

2. **Blocker - silently swallowed exception.** The catch block is empty (the comment even
   admits `// silent`). Any failure - expected or completely unrelated - disappears without
   a trace, making bugs impossible to diagnose in production.

3. **Major - the actual deduction logic is missing.** `// deduct from account` is only a
   comment, not real code. The method does not actually perform the one operation it exists
   to do.

4. **Major - catches an overly broad Exception type.** Catching the base `Exception` class
   hides real, unrelated bugs (like a NullPointerException from a missing account) right
   alongside expected validation failures, making debugging very difficult.

## Corrected method

```java
public void processPayment(double amount) {
    if (amount <= 0) {
        throw new IllegalArgumentException("Payment amount must be positive: " + amount);
    }

    if (account == null) {
        throw new IllegalStateException("No account associated with this payment.");
    }

    if (account.getBalance() < amount) {
        throw new IllegalStateException("Insufficient balance for payment of " + amount);
    }

    account.setBalance(account.getBalance() - amount);
    System.out.println("Payment of " + amount + " processed. New balance: " + account.getBalance());
}
```

## Explanation of the fix

- Validates `amount` up front and throws a specific, descriptive `IllegalArgumentException`
  instead of a vague checked `Exception`.
- Actually performs the deduction, instead of leaving it as an unimplemented comment.
- No more empty catch block - the method now lets exceptions propagate to the caller, who
  can decide how to handle them, rather than hiding failures silently.
- Uses specific exception types (`IllegalArgumentException`, `IllegalStateException`) so
  callers can catch and respond to different failure conditions distinctly.