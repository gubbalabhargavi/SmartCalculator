package com.savoira;

/**
 * Performs calculations for the SmartCalculator application.
 * Contains the core arithmetic logic, separated out from user input handling.
 */
public class Calculator {

    /**
     * Executes the calculation described by the given Operation.
     *
     * @param op the Operation containing the operands and operator
     * @return the result of the calculation, or Double.NaN if the
     *         operation is invalid (division by zero or unknown operator)
     */
    public double calculate(Operation op) {
        double a = op.getFirstOperand();
        double b = op.getSecondOperand();
        String operator = op.getOperator();

        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) {
                    System.out.println("Error: division by zero");
                    yield Double.NaN;
                } else {
                    yield a / b;
                }
            }
            case "%" -> a % b;
            default -> {
                System.out.println("Unknown operator");
                yield Double.NaN;
            }
        };
    }

    /**
     * Calculates the square root of a number.
     *
     * @param n the number to find the square root of
     * @return the square root of n, or Double.NaN if n is negative
     */
    public static double squareRoot(double n) {
        if (n < 0) {
            System.out.println("Error: cannot take square root of a negative number");
            return Double.NaN;
        }
        return Math.sqrt(n);
    }

    /**
     * Calculates what percentage the part is of the whole.
     *
     * @param part  the partial value
     * @param whole the total value
     * @return the percentage (part / whole * 100), or Double.NaN if whole is zero
     */
    public static double percentage(double part, double whole) {
        if (whole == 0) {
            System.out.println("Error: cannot calculate percentage of zero");
            return Double.NaN;
        }
        return (part / whole) * 100;
    }
}