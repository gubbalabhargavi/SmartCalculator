package com.savoira;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Represents a division operation between two numbers.
 * Uses BigDecimal internally to avoid floating-point precision drift,
 * and throws DivisionByZeroException instead of silently returning NaN.
 */
public class Division extends CalculableOperation implements Calculable {

    public Division(double firstOperand, double secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public double calculate() {
        if (secondOperand == 0) {
            throw new DivisionByZeroException();
        }
        BigDecimal bdFirst = BigDecimal.valueOf(this.firstOperand);
        BigDecimal bdSecond = BigDecimal.valueOf(this.secondOperand);
        return bdFirst.divide(bdSecond, 10, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public String toString() {
        return "Division: " + firstOperand + " / " + secondOperand + " = " + calculate();
    }
}