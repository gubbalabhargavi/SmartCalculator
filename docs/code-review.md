
# Phase 6 - Code Review Checklist & Self-Review

## Checklist (at least 5 items checked before every commit)

1. Does the code compile cleanly with `mvn clean compile`, with zero warnings or errors?
2. Are all public classes and methods documented with Javadoc, including `@param`/`@return`?
3. Are variable and method names descriptive (no single-letter names except loop counters)?
4. Does every error path throw or handle a specific exception, instead of silently
   returning a sentinel value like `NaN` or `null`?
5. Have I manually run the program and tested both the happy path and at least
   one failure case for anything I changed?

## Self-review

Reviewing this Phase 6 work against the checklist above, one thing I improved:
`Calculator.calculate()` originally returned `Double.NaN` for division-by-zero and
unknown operators, and the caller had to remember to check `Double.isNaN(result)`
before printing - easy to forget, and it silently swallowed real problems. I
replaced that with explicit `DivisionByZeroException` and `InvalidOperationException`
throws instead, so `Main` now handles every failure case through a proper
try-catch block, and it's impossible to accidentally ignore an error path.