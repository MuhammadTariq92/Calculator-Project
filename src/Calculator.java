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
            double result = CalculatorUtils.calculateExpression(input);
            System.out.println("Result: " + input + " = " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    