# SmartCalculator - Requirements and Design

## 5 Whys - Why does a user need a calculator app?

1. Why does a user need a calculator app?
   Because they need to perform quick arithmetic without doing it by hand.

2. Why do they need to do it without doing it by hand?
   Because manual calculation is slower and more error-prone, especially with decimals.

3. Why does speed and accuracy matter here?
   Because the user is often doing this mid-task (checking a bill, a budget, a formula) and wants the answer right away without breaking their workflow.

4. Why do they want it without breaking their workflow?
   Because switching to a heavier tool (spreadsheet, phone app with ads, browser search) adds friction and distraction.

5. Why does friction matter that much for something this small?
   Because a calculator is used dozens of times a day in small bursts, so even a few extra seconds of friction per use adds up to real lost time and annoyance over time.

**Insight:** The core value of a calculator app isn't just "doing math" - it's removing friction from a task the user repeats constantly. This means the CLI itself needs to be fast to use (minimal steps, clear prompts, no crashes that force a restart) more than it needs extra features.

## Functional Requirements

FR1: The calculator shall support +, -, *, /, and % operations.
FR2: The user shall enter two numbers and an operator via the command line.
FR3: The calculator shall run in a loop, accepting new calculations until the user types 'exit'.
FR4: Division by zero shall display a clear error message instead of crashing the program.
FR5: The calculator shall display results formatted to two decimal places.

## Non-Functional Requirements

NF1: Each calculation shall complete and display its result within 1 second.
NF2: Error messages shall be human-readable, not raw stack traces or exception names.

## What This Project Will NOT Build

- No graphical interface (beyond the static HTML/CSS preview in the final week).
- No backend server or database - this is a pure command-line application.

## Planned Class Structure

com.savoira/
  Main.java          - Entry point, reads user input via Scanner, runs the main loop
  Calculator.java     - Holds the calculate() logic, takes an Operation and returns a result
  Operation.java      - Represents a single calculation: two operands and an operator

As the project grows in later phases, Operation is expected to become an abstract class with concrete subclasses (Addition, Subtraction, Multiplication, Division) implementing a shared Calculable interface, to support polymorphism.