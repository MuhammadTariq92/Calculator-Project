import java.util.Scanner;
import java.util.NoSuchElementException;

public class Calculator {
    public static void main(String[] args) {
        String input = null;

        if (args.length > 0) {
            input = args[0]; // Use command-line argument if provided
        } else {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("****WELCOME TO CALCULATOR***** ");
                System.out.print("Enter an Expression (e.g., 5 + 10): ");

                if (!scanner.hasNextLine()) {
                    System.out.println("No input provided.");
                    return;
                }

                input = scanner.nextLine();
            } catch (NoSuchElementException e) {
                System.out.println("Error: No input provided.");
                return;
            }
        }

        // Attempt to split input by space
        String[] parts = input.split("\\s+");
        double num1, num2;
        char operator;

        // If splitting by space doesn't work, try splitting by operator
        if (parts.length != 3) {
            parts = input.split("[+\\-*/]");
            if (parts.length != 2) {
                System.out.println("Invalid input. Please use a valid format, e.g., '5 + 10'");
                return;
            }
            num1 = Double.parseDouble(parts[0]);
            operator = input.charAt(parts[0].length());
            num2 = Double.parseDouble(parts[1]);
        } else {
            try {
                num1 = Double.parseDouble(parts[0]);
                num2 = Double.parseDouble(parts[2]);
                operator = parts[1].charAt(0);
            } catch (NumberFormatException | IndexOutOfBoundsException e) {
                System.out.println("Invalid input. Please use a valid format, e.g., '5 + 10'");
                return;
            }
        }

        double result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Cannot Divide By Zero");
                    return;
                }
                break;
            default:
                System.out.println("Invalid operator. Please use one of +, -, *, /");
                return;
        }

        System.out.println("Result: " + num1 + " " + operator + " " + num2 + " = " + result);
    }

