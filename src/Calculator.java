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
            System.out.println("****WELCOME TO CALCULATOR***** ");
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
}

// Method to calculate the expression
public static double calculateExpression(String input) {

    // Remove all whitespace for simpler processing
    input = input.replaceAll("\\s+", "");
    double num1, num2;
    char operator = ' ';
    int operatorIndex = -1;