package com.savoira.assessment;

public class TypeDemo {

    public static void main(String[] args) {

        // Block 1
        int a = 9, b = 2;
        // Prediction: 9/2 -> 4 (integer division truncates), 9%2 -> 1 (remainder),
        // (double) a / b -> 4.5 (casting a to double first forces true decimal division)
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println((double) a / b);

        // Block 2
        Integer x = 100; Integer y = 100;
        Integer p = 200; Integer q = 200;
        // Prediction: x == y -> true, p == q -> false, p.equals(q) -> true
        System.out.println(x == y);
        System.out.println(p == q);
        System.out.println(p.equals(q));

        // WHY Block 2 gives different results for 100 vs 200:
        // Java caches Integer objects for values from -128 to 127 (the Integer cache).
        // Since 100 falls inside that range, x and y both point to the SAME cached
        // object, so x == y compares references and is true. 200 falls outside the
        // cached range, so each "Integer p = 200" creates a brand NEW object via
        // Integer.valueOf(200), meaning p and q are two different objects in memory
        // even though their values are equal - so p == q (reference comparison) is
        // false, while p.equals(q) (value comparison) is correctly true.
    }
}