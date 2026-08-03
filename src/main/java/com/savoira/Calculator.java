package com.savoira;

public class Calculator {

    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println("2 + 3 = " + calc.add(2, 3));
        System.out.println("5 - 2 = " + calc.subtract(5, 2));
        System.out.println("4 * 3 = " + calc.multiply(4, 3));
        System.out.println("10 / 2 = " + calc.divide(10, 2));
    }
}