import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
               Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an Expression (e.g., 5 + 10): ");
        String input = scanner.nextLine();

        // Split the input by space and extract the two numbers and the operator
        String[] parts = input.split(" ");
        double num1, num2;
        try {
            num1 = Double.parseDouble(parts[0]);
            num2 = Double.parseDouble(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please use a valid format, e.g., '5 + 10'");
            return;
        }

        char operator = parts[1].charAt(0);
        double result = 0;

        // Perform the calculation based on the operator
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
}

