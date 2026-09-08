package com.savoira;

/**
 * Represents a two-operand arithmetic operation that knows how to
 * calculate its own result. Concrete subclasses implement the specific
 * arithmetic logic for their operator.
 */
public abstract class CalculableOperation {

    protected double firstOperand;
    protected double secondOperand;

    /**
     * @param firstOperand  the first operand
     * @param secondOperand the second operand
     */
    public CalculableOperation(double firstOperand, double secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    /**
     * @return the result of applying this operation to its two operands
     */
    public abstract double calculate();
}