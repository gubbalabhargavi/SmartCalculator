package com.savoira;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Entry point for the SmartCalculator CLI application.
 * Handles reading user input and displaying output; all calculation
 * logic is delegated to the Calculator class.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        printBanner();

                while (true) {
            System.out.print("Enter first number, 'sqrt', 'pct', or 'exit': ");
            String input = sc.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            if (input.equalsIgnoreCase("sqrt")) {
                System.out.print("Enter number: ");
                double n = Double.parseDouble(sc.nextLine().trim());
                double result = Calculator.squareRoot(n);
                if (!Double.isNaN(result)) {
                    System.out.printf("Square root: %.2f%n", result);
                }
                System.out.println("------------------------------------");
                continue;
            }

            if (input.equalsIgnoreCase("pct")) {
                System.out.print("Enter part value: ");
                double part = Double.parseDouble(sc.nextLine().trim());
                System.out.print("Enter whole value: ");
                double whole = Double.parseDouble(sc.nextLine().trim());
                double result = Calculator.percentage(part, whole);
                if (!Double.isNaN(result)) {
                    System.out.printf("Percentage: %.2f%%%n", result);
                }
                System.out.println("------------------------------------");
                continue;
            }

            double firstNumber = Double.parseDouble(input);

            System.out.print("Enter operator (+ - * / %): ");
            String operator = sc.nextLine().trim();

            System.out.print("Enter second number: ");
            double secondNumber = Double.parseDouble(sc.nextLine().trim());

            Operation operation = new Operation(firstNumber, secondNumber, operator);
            double result = calculator.calculate(operation);

            if (!Double.isNaN(result)) {
                System.out.printf("Result: %.2f%n", result);
            }
            System.out.println("------------------------------------");
        }

        LOGGER.info("SmartCalculator session ended. Goodbye!");
    }

    /**
     * Prints a decorated banner shown once when the application starts.
     */
    private static void printBanner() {
        System.out.println("======================================");
        System.out.println("       ===  SmartCalculator  ===       ");
        System.out.println("======================================");
        System.out.println("   Type 'exit' at any time to quit.");
        System.out.println("======================================");
    }
}