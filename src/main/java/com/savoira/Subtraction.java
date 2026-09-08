package com.savoira;

/**
 * Represents a subtraction operation between two numbers.
 */
public class Subtraction extends CalculableOperation implements Calculable {

    public Subtraction(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        return firstOperand - secondOperand;
    }

    @Override
    public String toString() {
        return "Subtraction: " + firstOperand + " - " + secondOperand + " = " + calculate();
    }
}