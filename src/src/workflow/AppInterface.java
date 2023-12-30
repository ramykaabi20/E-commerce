package src.workflow;

import java.util.Scanner;

public class AppInterface {
    public static void AppInterface() {
        Scanner scanner = new Scanner(System.in);
        boolean isLoggedIn = false;
        int choice;
        System.out.println("Welcome to the Online Store!");
        System.out.println("Please login or register to continue.");


        // Menu loop
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login.login();
                    break;
                case 2 :
                    System.out.println("Thank you for using the E-Commerce App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        } while (choice !=2);

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n=== E-Commerce Console App Menu ===");
        System.out.println("1. User Authentication");
        System.out.println("2. Logout");
        System.out.println("3. Exit");
    }
}


