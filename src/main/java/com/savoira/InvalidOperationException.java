package com.savoira;

/**
 * Thrown when the user enters an operator that the calculator does not
 * recognize (anything other than +, -, *, /, %).
 */
public class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String message) {
        super(message);
    }
}
