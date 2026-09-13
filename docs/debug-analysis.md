# Debug Analysis - sumEvens()

## Original buggy method

```java
public static int sumEvens(int n) {
    int sum = 1;
    for (int i = 1; i <= n; i++) {
        if (i % 2 == 1)
            sum += i;
    }
    return sum;
}
```

Running sumEvens(10) on the buggy version returns 26, not the expected 30.

## Bug 1: incorrect initial value

`int sum = 1;` starts the accumulator at 1 instead of 0. Since we're summing
even numbers via addition, the correct starting (identity) value is 0 - any
nonzero starting value shifts every result upward by that amount. I identified
this by manually tracing the expected sum (2+4+6+8+10 = 30) against the
buggy output and noticing the buggy result was consistently offset.

## Bug 2: wrong condition

`if (i % 2 == 1)` checks whether `i` is odd, not even. `% 2 == 1` is true for
odd numbers; the correct check for even numbers is `% 2 == 0`. I identified
this by checking which numbers the loop was actually summing - it was adding
1, 3, 5, 7, 9 (the odd numbers) instead of 2, 4, 6, 8, 10.

## Combined effect

With both bugs present, the buggy method actually sums the odd numbers
(1+3+5+7+9 = 25) plus the incorrect starting value of 1, giving 25 + 1 = 26 -
which matches the actual buggy output observed when run.

## Fixed method

```java
public static int sumEvensFixed(int n) {
    int sum = 0;
    for (int i = 1; i <= n; i++) {
        if (i % 2 == 0)
            sum += i;
    }
    return sum;
}
```

This correctly returns 30 for n=10, matching the expected result.