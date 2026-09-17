# Code Review - Assessment 2, Task D2

## Original dirty method

```java
public double x(double a, double b, int c) { 
    double r = 1; 
    for(int i=0;i<c;i++) {r = r*(1+b);} 
    return a*r; 
}
```

## The five clean-code problems found

1. **Non-descriptive method name** - `x` gives no indication of what the method computes. A reader has to trace through the logic to guess it's a compound growth calculation.
2. **Non-descriptive parameter names** - `a`, `b`, `c` don't communicate their purpose (principal, rate, number of periods).
3. **Non-descriptive local variable name** - `r` doesn't indicate it holds a running growth multiplier.
4. **Poor formatting** - no spaces around operators (`i<c`, `r*(1+b)`), the entire loop body crammed onto one line, inconsistent brace placement.
5. **No documentation** - there is no comment or Javadoc explaining what formula this implements, what the parameters mean, or what is returned.

## Rewritten method

```java
/**
 * Calculates the final amount after applying compound growth for a
 * fixed number of periods.
 *
 * @param principal      the starting principal amount
 * @param growthRate     the growth rate per period, as a decimal (e.g. 0.08 for 8%)
 * @param numberOfPeriods the number of periods the growth is applied over
 * @return the final amount after compound growth has been applied
 */
public double calculateCompoundGrowth(double principal, double growthRate, int numberOfPeriods) {
    double growthFactor = 1;

    for (int period = 0; period < numberOfPeriods; period++) {
        growthFactor = growthFactor * (1 + growthRate);
    }

    return principal * growthFactor;
}
```