package com.savoira;

/**
 * Represents a single calculation request: two operands and an operator.
 * This class only holds data - it does not perform any calculation itself.
 */
public class Operation {

    private final double firstOperand;
    private final double secondOperand;
    private final String operator;

    /**
     * Creates a new Operation.
     *
     * @param firstOperand  the first number in the calculation
     * @param secondOperand the second number in the calculation
     * @param operator      the operator symbol, e.g. "+", "-", "*", "/", "%"
     */
    public Operation(double firstOperand, double secondOperand, String operator) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operator = operator;
    }

    /**
     * @return the first operand of this operation
     */
    public double getFirstOperand() {
        return firstOperand;
    }

    /**
     * @return the second operand of this operation
     */
    public double getSecondOperand() {
        return secondOperand;
    }

    /**
     * @return the operator symbol for this operation
     */
    public String getOperator() {
        return operator;
    }
}