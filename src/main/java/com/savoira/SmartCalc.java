package com.savoira;

import java.util.Scanner;

/*
 * Expected output for test cases:
 * Input: 8 + 5        -> Result: 13.00
 * Input: 8 / 0         -> Error: Division by zero
 * Input: 8 ^ 5         -> Error: Unknown operator '^'
 */
public class SmartCalc {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter first number (or 'exit' to quit): ");
            String firstInput = scanner.next();

            if (firstInput.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            double num1 = Double.parseDouble(firstInput);

            System.out.print("Enter operator (+ - * / %): ");
            String operator = scanner.next();

            System.out.print("Enter second number: ");
            double num2 = scanner.nextDouble();

            String result = switch (operator) {
                case "+" -> String.format("Result: %.2f", num1 + num2);
                case "-" -> String.format("Result: %.2f", num1 - num2);
                case "*" -> String.format("Result: %.2f", num1 * num2);
                case "/" -> {
                    if (num2 == 0) {
                        yield "Error: Division by zero";
                    }
                    yield String.format("Result: %.2f", num1 / num2);
                }
                case "%" -> {
                    if (num2 == 0) {
                        yield "Error: Division by zero";
                    }
                    yield String.format("Result: %.2f", num1 % num2);
                }
                default -> "Error: Unknown operator '" + operator + "'";
            };

            System.out.println(result);
            System.out.println();
        }

        scanner.close();
    }
}