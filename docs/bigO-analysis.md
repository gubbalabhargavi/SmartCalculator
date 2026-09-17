# Big O Analysis

## Block X - Nested loop

```java
for (int i = 0; i < n; i++)
    for (int j = 0; j < n; j++)
        System.out.println(i + "," + j);
```

Time complexity: O(n^2)

Why: for every value of i (n values), the inner loop runs n times, so the
total number of println calls is n * n = n^2.

If n doubles: operations become (2n)^2 = 4n^2 - 4 times more operations.

## Block Y - Halving loop

```java
int mid = n / 2;
while (mid > 0) mid = mid / 2;
```

Time complexity: O(log n)

Why: each iteration divides mid by 2, so the number of iterations needed to
reach 0 is approximately log base 2 of n.

If n doubles: log(2n) = log(n) + log(2) = log(n) + 1 - only one additional
iteration is needed, regardless of how large n already is.

## Block Z - Single loop

```java
for (int i = 0; i < n; i++)
    System.out.println(arr[i]);
```

Time complexity: O(n)

Why: the loop runs exactly n times, doing one constant-time operation
(println) per iteration.

If n doubles: operations exactly double, since the work scales linearly
with n.