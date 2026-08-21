# Code Smells - Week 5 Assignment 2, Task 6

## Original method

```java
void process(List<Loan> l) {
    for(int i=0;i<l.size();i++){
        if(l.get(i).principal>500000&&l.get(i).principal<2000000)
            System.out.println(l.get(i).loanId);
    }
}
```

## Two code smells found

1. **Non-descriptive naming** - the parameter `l` and loop variable `i` give no
   indication of what they represent. Combined with `l.get(i)`, the code reads
   as cryptic shorthand rather than expressing intent.
2. **Magic numbers and repeated indexed access** - `500000` and `2000000` are
   unexplained thresholds with no named meaning, and `l.get(i)` is called three
   separate times instead of once, along with cramped formatting (no spacing
   around operators, everything on tight single lines).

## Refactored method

```java
private static final double MID_RANGE_LOAN_MIN = 500000;
private static final double MID_RANGE_LOAN_MAX = 2000000;

/**
 * Prints the loan ID of every loan in the list whose principal falls
 * strictly between the mid-range loan thresholds.
 *
 * @param loans the list of loans to scan
 */
void printMidRangeLoanIds(List<Loan> loans) {
    for (Loan loan : loans) {
        if (loan.principal > MID_RANGE_LOAN_MIN && loan.principal < MID_RANGE_LOAN_MAX) {
            System.out.println(loan.loanId);
        }
    }
}
```