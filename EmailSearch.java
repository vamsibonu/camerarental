package project;

import java.util.Scanner;

public class EmailSearch {

    public static boolean searchEmail(String[] emails, String targetEmail) {
        for (String email : emails) {
            if (email.equals(targetEmail)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Example array of employee email IDs
        String[] employeeEmails = {"employee1@example.com", "employee2@example.com", "employee3@example.com"};

        // Taking user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the email ID to search: ");
        String userInput = scanner.nextLine();

        // Performing the search
        if (searchEmail(employeeEmails, userInput)) {
            System.out.println("Email ID found!");
        } else {
            System.out.println("Email ID not found.");
        }

        // Close the scanner
        scanner.close();
    }
}
