package com.savoira;

/**
 * Represents a division operation between two numbers.
 */
public class Division extends CalculableOperation implements Calculable {

    public Division(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        if (secondOperand == 0) {
            return Double.NaN;
        }
        return firstOperand / secondOperand;
    }

    @Override
    public String toString() {
        return "Division: " + firstOperand + " / " + secondOperand + " = " + calculate();
    }
}