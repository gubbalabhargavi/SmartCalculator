package com.savoira;

import java.util.logging.Logger;

/**
 * Performs calculations for the SmartCalculator application.
 * Contains the core arithmetic logic, separated out from user input handling.
 */
public class Calculator {

    private static final Logger LOGGER = Logger.getLogger(Calculator.class.getName());

    /**
     * Executes the calculation described by the given Operation.
     *
     * @param op the Operation containing the operands and operator
     * @return the result of the calculation, or Double.NaN if the
     *         operation is invalid (division/modulo by zero or unknown operator)
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
                    LOGGER.severe("Error: division by zero");
                    yield Double.NaN;
                } else {
                    yield firstNumber / secondNumber;
                }
            }
            case "%" -> {
                if (secondNumber == 0) {
                    LOGGER.severe("Error: modulo by zero");
                    yield Double.NaN;
                } else {
                    yield firstNumber % secondNumber;
                }
            }
            default -> {
                LOGGER.severe("Unknown operator: " + operator);
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
            LOGGER.severe("Error: cannot take square root of a negative number");
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
            LOGGER.severe("Error: cannot calculate percentage of zero");
            return Double.NaN;
        }
        return (part / whole) * 100;
    }
}