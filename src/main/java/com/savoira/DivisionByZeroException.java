package com.savoira;

/**
 * Thrown when a division operation is attempted with a zero denominator.
 */
public class DivisionByZeroException extends ArithmeticException {
    public DivisionByZeroException() {
        super("Cannot divide by zero");
    }
}