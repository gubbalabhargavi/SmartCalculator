# ATM Withdrawal Pseudocode

SET balance = 10000
SET attempts = 0
SET maxAttempts = 3

WHILE attempts < maxAttempts:
    PROMPT user to enter withdrawal amount
    READ amount

    IF amount < 500 THEN
        DISPLAY "Amount must be at least Rs.500"
        INCREMENT attempts
        CONTINUE to next iteration

    IF amount > 20000 THEN
        DISPLAY "Amount cannot exceed Rs.20,000"
        INCREMENT attempts
        CONTINUE to next iteration

    IF amount is NOT a multiple of 500 THEN
        DISPLAY "Amount must be a multiple of Rs.500"
        INCREMENT attempts
        CONTINUE to next iteration

    IF amount > balance THEN
        DISPLAY "Insufficient balance"
        INCREMENT attempts
        CONTINUE to next iteration

    // All rules passed
    balance = balance - amount
    DISPLAY "Withdrawal successful. New balance: " + balance
    EXIT loop

END WHILE

IF attempts reached maxAttempts (loop ended without success) THEN
    DISPLAY "Card locked."