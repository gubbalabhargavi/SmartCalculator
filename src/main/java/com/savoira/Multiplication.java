package com.savoira;

/**
 * Represents a multiplication operation between two numbers.
 */
public class Multiplication extends CalculableOperation implements Calculable {

    public Multiplication(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        return firstOperand * secondOperand;
    }

    @Override
    public String toString() {
        return "Multiplication: " + firstOperand + " * " + secondOperand + " = " + calculate();
    }
}