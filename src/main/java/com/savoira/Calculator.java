package com.savoira;

/**
 * Performs calculations for the SmartCalculator application.
 * Contains the core arithmetic logic, separated out from user input handling.
 * Invalid operations throw exceptions rather than returning sentinel values,
 * so callers can handle them explicitly with try-catch.
 */
public class Calculator {

    /**
     * Executes the calculation described by the given Operation.
     *
     * @param op the Operation containing the operands and operator
     * @return the result of the calculation
     * @throws DivisionByZeroException  if dividing or taking modulo by zero
     * @throws InvalidOperationException if the operator is not recognized
     */
    public double calculate(Operation op) {
        double firstNumber = op.getFirstOperand();
        double secondNumber = op.getSecondOperand();
        String operator = op.getOperator();

        return switch (operator) {
            case "+" -> firstNumber + secondNumber;
            case "-" -> firstNumber - secondNumber;
            case "*" -> firstNumber * secondNumber;
            case "/" -> {
                if (secondNumber == 0) {
                    throw new DivisionByZeroException();
                }
                yield firstNumber / secondNumber;
            }
            case "%" -> {
                if (secondNumber == 0) {
                    throw new DivisionByZeroException();
                }
                yield firstNumber % secondNumber;
            }
            default -> throw new InvalidOperationException("Unknown operator: " + operator);
        };
    }

    /**
     * Calculates the square root of a number.
     *
     * @param n the number to find the square root of
     * @return the square root of n
     * @throws InvalidOperationException if n is negative
     */
    public static double squareRoot(double n) {
        if (n < 0) {
            throw new InvalidOperationException("Cannot take square root of a negative number");
        }
        return Math.sqrt(n);
    }

    /**
     * Calculates what percentage the part is of the whole.
     *
     * @param part  the partial value
     * @param whole the total value
     * @return the percentage (part / whole * 100)
     * @throws InvalidOperationException if whole is zero
     */
    public static double percentage(double part, double whole) {
        if (whole == 0) {
            throw new InvalidOperationException("Cannot calculate percentage of zero");
        }
        return (part / whole) * 100;
    }
}