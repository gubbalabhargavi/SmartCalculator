# Dry Run - withdraw(7500)

Starting state: balance = 10000, amount = 7500, attempts = 0

| Step | Check | balance | amount | attempts | Result |
|------|-------|---------|--------|----------|--------|
| 1 | Enter withdraw(7500) | 10000 | 7500 | 0 | - |
| 2 | amount < 500? (7500 < 500) | 10000 | 7500 | 0 | False - continue |
| 3 | amount > 20000? (7500 > 20000) | 10000 | 7500 | 0 | False - continue |
| 4 | amount % 500 != 0? (7500 % 500 = 0) | 10000 | 7500 | 0 | False - continue |
| 5 | amount > balance? (7500 > 10000) | 10000 | 7500 | 0 | False - continue |
| 6 | balance -= amount | 2500 | 7500 | 0 | balance updated |
| 7 | Print "Withdrawal successful. New balance: Rs.2500.0" | 2500 | 7500 | 0 | Success |

Final state: balance = 2500, attempts remains 0 (no exception was thrown, so
attempts was never incremented). The withdrawal succeeds on the first try
since 7500 passes all four validation rules.