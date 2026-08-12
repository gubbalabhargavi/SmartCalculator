package com.savoira;

import java.util.Scanner;

/**
 * Entry point for the SmartCalculator CLI application.
 * Handles reading user input and displaying output; all calculation
 * logic is delegated to the Calculator class.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("=== SmartCalculator ===");
        System.out.println("Type 'exit' to quit.");

        while (true) {
            System.out.print("Enter first number (or 'exit'): ");
            String input = sc.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) break;

            double a = Double.parseDouble(input);

            System.out.print("Enter operator (+ - * / %): ");
            String op = sc.nextLine().trim();

            System.out.print("Enter second number: ");
            double b = Double.parseDouble(sc.nextLine().trim());

            Operation operation = new Operation(a, b, op);
            double result = calculator.calculate(operation);

            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f%n", result);
            }
        }

        System.out.println("Goodbye!");
    }
}