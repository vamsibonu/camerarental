package project;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        System.out.println("3. Multiply");
        System.out.println("4. Divide");

        System.out.print("Enter choice (1/2/3/4): ");
        char choice = scanner.next().charAt(0);

        System.out.print("Enter first number: ");
        double num1 = scanner.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = scanner.nextDouble();

        double result;

        switch (choice) {
            case '1':
                result = add(num1, num2);
                System.out.println(num1 + " + " + num2 + " = " + result);
                break;
            case '2':
                result = subtract(num1, num2);
                System.out.println(num1 + " - " + num2 + " = " + result);
                break;
            case '3':
                result = multiply(num1, num2);
                System.out.println(num1 + " * " + num2 + " = " + result);
                break;
            case '4':
                result = divide(num1, num2);
                if (!Double.isNaN(result)) {
                    System.out.println(num1 + " / " + num2 + " = " + result);
                } else {
                    System.out.println("Error: Division by zero");
                }
                break;
            default:
                System.out.println("Invalid Input");
        }

        scanner.close();
    }

    public static double add(double x, double y) {
        return x + y;
    }

    public static double subtract(double x, double y) {
        return x - y;
    }

    public static double multiply(double x, double y) {
        return x * y;
    }

    public static double divide(double x, double y) {
        if (y != 0) {
            return x / y;
        } else {
            return Double.NaN; // Indicate an error for division by zero
        }
    }
}


