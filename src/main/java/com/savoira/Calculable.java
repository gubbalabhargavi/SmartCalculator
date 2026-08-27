package com.savoira;

/**
 * Represents anything that can produce a calculated double result.
 */
public interface Calculable {

    /**
     * @return the result of this calculation
     */
    double calculate();
}