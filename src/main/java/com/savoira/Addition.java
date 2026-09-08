package com.savoira;

/**
 * Represents an addition operation between two numbers.
 */
public class Addition extends CalculableOperation implements Calculable {

    public Addition(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        return firstOperand + secondOperand;
    }

    @Override
    public String toString() {
        return "Addition: " + firstOperand + " + " + secondOperand + " = " + calculate();
    }
}