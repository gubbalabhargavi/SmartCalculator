package com.savoira;

import java.util.List;
import java.util.logging.Logger;

/**
 * Demonstrates runtime polymorphism using the CalculableOperation hierarchy.
 * A single List<Calculable> holds different operation types, and calling
 * calculate() on each resolves to that object's own specific logic at runtime.
 */
public class PolymorphismDemo {

    private static final Logger LOGGER = Logger.getLogger(PolymorphismDemo.class.getName());

    public static void main(String[] args) {

        List<Calculable> ops = List.of(
                new Addition(10, 4),
                new Subtraction(10, 4),
                new Multiplication(10, 4),
                new Division(10, 4)
        );

        LOGGER.info("----- Polymorphism Demo -----");
        for (Calculable op : ops) {
            System.out.println(op.toString());
        }
    }
}