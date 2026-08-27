package com.savoira;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Entry point for the SmartCalculator CLI application.
 * Handles reading user input and displaying output; all calculation
 * logic is delegated to the Calculator class. Invalid input and
 * calculation errors are handled through try-catch exception handling
 * rather than manual if-checks, so the loop never crashes.
 */
public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        printBanner();

        while (true) {
            try {
                System.out.print("Enter first number, 'sqrt', 'pct', or 'exit': ");
                String input = sc.nextLine().trim();

                if (input.equalsIgnoreCase("exit")) {
                    break;
                }

                if (input.equalsIgnoreCase("sqrt")) {
                    handleSquareRoot(sc);
                    continue;
                }

                if (input.equalsIgnoreCase("pct")) {
                    handlePercentage(sc);
                    continue;
                }

                double firstNumber = Double.parseDouble(input);

                System.out.print("Enter operator (+ - * / %): ");
                String operator = sc.nextLine().trim();

                System.out.print("Enter second number: ");
                double secondNumber = Double.parseDouble(sc.nextLine().trim());

                if (!isValidOperator(operator)) {
                    throw new InvalidOperationException("Unknown operator: " + operator);
                }

                Operation operation = new Operation(firstNumber, secondNumber, operator);
                double result = calculator.calculate(operation);

                System.out.printf("Result: %.2f%n", result);

            } catch (NumberFormatException e) {
                LOGGER.warning("Please enter a valid number.");
            } catch (DivisionByZeroException | InvalidOperationException e) {
                LOGGER.warning(e.getMessage());
            } catch (Exception e) {
                LOGGER.severe("Unexpected error: " + e.getMessage());
            } finally {
                System.out.println("------------------------------------");
            }
        }

        LOGGER.info("SmartCalculator session ended. Goodbye!");
    }

    /**
     * Handles the 'sqrt' command: reads one number and prints its square root.
     *
     * @param sc the Scanner to read input from
     */
    private static void handleSquareRoot(Scanner sc) {
        System.out.print("Enter number: ");
        double n = Double.parseDouble(sc.nextLine().trim());
        double result = Calculator.squareRoot(n);
        System.out.printf("Square root: %.2f%n", result);
    }

    /**
     * Handles the 'pct' command: reads a part and whole value and prints the percentage.
     *
     * @param sc the Scanner to read input from
     */
    private static void handlePercentage(Scanner sc) {
        System.out.print("Enter part value: ");
        double part = Double.parseDouble(sc.nextLine().trim());
        System.out.print("Enter whole value: ");
        double whole = Double.parseDouble(sc.nextLine().trim());
        double result = Calculator.percentage(part, whole);
        System.out.printf("Percentage: %.2f%%%n", result);
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


    /**
     * Checks whether the given operator is one this calculator supports.
     *
     * @param op the operator symbol to check
     * @return true if op is one of +, -, *, /, %, false otherwise
     */
    private static boolean isValidOperator(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/") || op.equals("%");
    }
}