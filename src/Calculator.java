import java.util.Scanner;
import java.util.NoSuchElementException;

public class Calculator {
    public static void main(String[] args) {
        String input = null;

        // Get input either from command-line arguments or user input
        if (args.length > 0) {
            input = args[0]; // Use command-line argument if provided
        } else {
            input = getInputFromUser();
            if (input == null) {
                return; // Exit if no input was provided
            }
        }

        // Attempt to parse and calculate the input expression
        try {
            double result = Calculator.calculateExpression(input);
            System.out.println("Result: " + input + " = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to get input from the user
    private static String getInputFromUser() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("****WELCOME TO BASIC ARITHMETIC CALCULATOR***** ");
            System.out.print("Enter an Expression (e.g., 5 + 10): ");

            if (!scanner.hasNextLine()) {
                System.out.println("No input provided.");
                return null;
            }

            return scanner.nextLine();
        } catch (NoSuchElementException e) {
            System.out.println("Error: No input provided.");
            return null;
        }
    }


    // Method to calculate the expression
    public static double calculateExpression(String input) {
        // Remove all whitespace for simpler processing
        input = input.replaceAll("\\s+", "");
        double num1, num2;
        char operator = ' ';
        int operatorIndex = -1;

        // Find the operator and its index
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                operator = c;
                operatorIndex = i;
                break;
            }
        }

        // If no operator was found, throw an exception
        if (operatorIndex == -1) {
            throw new IllegalArgumentException("Invalid input. Please use a valid format, e.g., '5 + 10'");
        }

        // Attempt to parse the numbers on either side of the operator
        try {
            num1 = Double.parseDouble(input.substring(0, operatorIndex));
            num2 = Double.parseDouble(input.substring(operatorIndex + 1));
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            // If parsing fails, throw an exception
            throw new IllegalArgumentException("Invalid input. Please use a valid format, e.g., '5 + 10'");
        }

        // Perform the mathematical operation and return the result
        return performOperation(num1, num2, operator);
    }

    // Method to perform the mathematical operation
    private static double performOperation(double num1, double num2, char operator) {
        switch (operator) {
            case '+':
                return num1 + num2; // Perform addition
            case '-':
                return num1 - num2; // Perform subtraction
            case '*':
                return num1 * num2; // Perform multiplication
            case '/':
                if (num2 != 0) {
                    return num1 / num2; // Perform division if the divisor is not zero
                } else {
                    throw new IllegalArgumentException("Cannot Divide By Zero"); // Handle division by zero
                }
            default:
                throw new IllegalArgumentException("Invalid operator. Please use one of +, -, *, /"); // Handle invalid operators
        }
    }
}
