package com.savoira;

public class TypesDemo {

    public static void main(String[] args) {

        // Block 1: integer division
        int a = 17, b = 5;
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println((double) a / b);

        // Block 2: Integer cache
        Integer x = 127; Integer y = 127;
        Integer p = 200; Integer q = 200;
        System.out.println(x == y);
        System.out.println(p == q);
        System.out.println(p.equals(q));

        // Line 4 (x == y) is true and line 5 (p == q) is false because Java caches
        // and reuses Integer objects for values from -128 to 127 (the Integer cache),
        // so x and y point to the same cached object, but 200 falls outside that
        // range and each Integer.valueOf(200) call creates a separate new object,
        // so p and q are different objects even though their values are equal.
    }
}