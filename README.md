<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Calculator Project</title>
</head>
<body>
    <h1>Basic Arithmetic Calculator in Java</h1>
    <p>This project implements a basic arithmetic calculator in Java that performs operations such as addition, subtraction, multiplication, and division.</p>

    <h2>Table of Contents</h2>
    <ul>
        <li><a href="#features">Features</a></li>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
        <li><a href="#usage">Usage</a></li>
        <li><a href="#code-overview">Code Overview</a></li>
        <li><a href="#contributing">Contributing</a></li>
        <li><a href="#license">License</a></li>
    </ul>

    <h2 id="features">Features</h2>
    <ul>
        <li>Supports basic arithmetic operations: addition, subtraction, multiplication, and division.</li>
        <li>Accepts input via command-line arguments or user input.</li>
        <li>Handles invalid input and provides appropriate error messages.</li>
    </ul>

    <h2 id="prerequisites">Prerequisites</h2>
    <ul>
        <li>Java Development Kit (JDK) installed on your machine.</li>
        <li>Basic knowledge of Java programming.</li>
        <li>Git installed for cloning the repository.</li>
    </ul>

    <h2 id="installation">Installation</h2>
    <ol>
        <li>Clone the repository from GitHub:
            <pre><code>git clone https://github.com/username/calculator.git</code></pre>
        </li>
        <li>Navigate to the project directory:
            <pre><code>cd calculator</code></pre>
        </li>
        <li>Compile the Java program:
            <pre><code>javac Calculator.java</code></pre>
        </li>
    </ol>

    <h2 id="usage">Usage</h2>
    <p>Run the compiled Java program and provide an arithmetic expression:</p>
    <pre><code>java Calculator "5 + 10"</code></pre>
    <p>Alternatively, run the program without arguments to enter an expression interactively:</p>
    <pre><code>java Calculator</code></pre>
    <p>Example:</p>
    <pre><code>
****WELCOME TO BASIC ARITHMETIC CALCULATOR***** 
Enter an Expression (e.g., 5 + 10): 5 * 3
Result: 5*3 = 15.0
    </code></pre>

    <h2 id="code-overview">Code Overview</h2>
    <pre><code>
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
    </code></pre>

    <h2 id="contributing">Contributing</h2>
    <p>Contributions are welcome! Please fork this repository and submit a pull request for any enhancements or bug fixes.</p>

    <h2 id="license">License</h2>
    <p>This project is licensed under the MIT License. See the <a href="LICENSE">LICENSE</a> file for details.</p>
</body>
</html>
