package com.virtunexa;

import com.virtunexa.Database.DatabaseManager;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CLIFrontend {
    public static void start() {
        // Using try-with-resources to ensure the Scanner is closed properly
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("-------- Welcome to VirtuNexa Factorial Converter --------");

            System.out.print("\nEnter your username: ");
            String username = scanner.nextLine();

            System.out.println("\nInstructions:");
            System.out.println("1. Input a non-negative integer and choose the method to calculate its factorial.");
            System.out.println("2. To view calculation history, type \"3\".");
            System.out.println("3. To exit, type \"4\".");

            boolean exit = false;
            while (!exit) {
                System.out.println("\nSelect an option:");
                System.out.println("1. Iterative Method");
                System.out.println("2. Recursive Method");
                System.out.println("3. View Calculation History");
                System.out.println("4. Exit");
                System.out.print("\nEnter your choice: ");

                int choice = getValidInt(scanner);
                switch (choice) {
                    case 1:
                        processCalculation(scanner, username, "Iterative");
                        break;
                    case 2:
                        processCalculation(scanner, username, "Recursive");
                        break;
                    case 3:
                        DatabaseManager.showConversionHistory();
                        break;
                    case 4:
                        System.out.println("\nHope you liked it...");
                        System.out.println("Developed By- Madhur Gupta");
                        System.out.println("Exiting...");
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid input. Please try again.");
                        break;
                }
            }
        }
    }

    // Helper method to process factorial calculation
    private static void processCalculation(Scanner scanner, String username, String method) {
        System.out.print("Enter a non-negative integer: ");
        int number = getValidInt(scanner);
        if (number < 0) {
            System.out.println("Please enter a non-negative integer.");
            return;
        }
        int result;
        if ("Iterative".equalsIgnoreCase(method)) {
            result = FactorialCalculator.calculateFactorialIteratively(number);
        } else {
            result = FactorialCalculator.calculateFactorialRecursively(number);
        }
        System.out.println("Factorial of " + number + " is: " + result);
        DatabaseManager.insertCalculationData(username, method, number, result);
    }

    // Helper method for input validation
    private static int getValidInt(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter an integer: ");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}
