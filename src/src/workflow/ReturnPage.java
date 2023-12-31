package src.workflow;

import java.util.Scanner;

public class ReturnPage {
    public static void ReturnPage() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("PRESS 1 TO LOGOUT: \n");
        System.out.println("PRESS 2 TO ACCESS PRODUCTS: \n");
        System.out.println("PRESS 3 TO EXIT:\n");
        int choice = scanner.nextInt();
        if (choice == 1) {
            AppInterface.AppInterface();
        } else if (choice == 2) {
            ProductMenu.ProductMenu();
        } else if (choice == 3) {
            System.out.println("Thank you for using the E-Commerce App. Goodbye!");
        }
    }
}
