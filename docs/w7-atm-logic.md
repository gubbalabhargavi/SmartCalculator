# ATM Withdrawal Logic - Pseudocode, Dry Run, and Output

## Task 1: Pseudocode

SET attempts = 0
SET maxAttempts = 3

WHILE attempts < maxAttempts:
    PROMPT user to enter withdrawal amount
    READ amount

    IF amount < 500 THEN
        DISPLAY "Withdrawal amount must be at least Rs.500"
        INCREMENT attempts
        CONTINUE to next loop iteration

    IF amount > 20000 THEN
        DISPLAY "Withdrawal amount cannot exceed Rs.20,000"
        INCREMENT attempts
        CONTINUE to next loop iteration

    IF amount is NOT a multiple of 500 THEN
        DISPLAY "Withdrawal amount must be a multiple of Rs.500"
        INCREMENT attempts
        CONTINUE to next loop iteration

    IF amount > current account balance THEN
        DISPLAY "Insufficient balance"
        INCREMENT attempts
        CONTINUE to next loop iteration

    // All five rules passed
    DEDUCT amount from account balance
    DISPENSE cash to user
    DISPLAY "Withdrawal successful. New balance: " + balance
    EXIT loop (successful withdrawal, stop retrying)

END WHILE

IF attempts reached maxAttempts (loop ended without a successful withdrawal) THEN
    DISPLAY "Maximum attempts exceeded. Card locked."
    LOCK the card


## Task 3: Dry Run Trace

Code being traced:

```java
int balance = 3000;
int count   = 0;
int[] txns  = {500, -200, 1000, -300, 800};
for (int i = 0; i < txns.length; i++) {
    balance += txns[i];
    if (txns[i] > 0) count++;
}
System.out.println("Balance: " + balance);
System.out.println("Deposits: " + count);
```

| i | txns[i] | balance += txns[i] | txns[i] > 0 ? | count |
|---|---------|---------------------|---------------|-------|
| start | - | 3000 | - | 0 |
| 0 | 500 | 3000 + 500 = 3500 | Yes | 1 |
| 1 | -200 | 3500 - 200 = 3300 | No | 1 |
| 2 | 1000 | 3300 + 1000 = 4300 | Yes | 2 |
| 3 | -300 | 4300 - 300 = 4000 | No | 2 |
| 4 | 800 | 4000 + 800 = 4800 | Yes | 3 |

## Task 4: Final Output and Explanation

Final output:

Balance: 4800
Deposits: 3

Explanation: The loop iterates once per element of txns, adding each value to
balance regardless of its sign - positive values increase the balance, negative
values decrease it. Starting from 3000, the five additions are +500, -200, +1000,
-300, and +800, which sum to +1800, giving a final balance of 4800. The count
variable only increments when the current element is strictly greater than 0;
three of the five values (500, 1000, and 800) are positive, so count ends at 3.