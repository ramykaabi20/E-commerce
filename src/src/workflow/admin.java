package src.workflow;

import LocalDB.LocalDB;
import Models.Electronics;
import Models.Fashion;
import Models.Product;

import java.util.Scanner;

public class admin {
    static void ADMIN_Workflow(Scanner scanner) {
        int adminChoice;
        do {
            System.out.println("Press 1 to add a product\nPress 2 to remove a product\nPress 3 to exit");
            adminChoice = scanner.nextInt();
            switch (adminChoice) {
                case 1:
                    System.out.println("Enter product category: Press 0 for Electronics,Press 1 for Fashion");
                    int category = scanner.nextInt();
                    if (category == 0) {
                        System.out.println("Enter product ID:");
                        int productId = scanner.nextInt();
                        System.out.println("Enter product name:");
                        String productName = scanner.next();
                        System.out.println("Enter product price:");
                        double productPrice = scanner.nextDouble();
                        System.out.println("Enter product quantity:");
                        int productQuantity = scanner.nextInt();
                        Product product = new Electronics(productId, productName, productPrice, productQuantity);
                        LocalDB.getLocalDB().addProduct(product);
                        System.out.println("Product added successfully!");
                    } else if (category == 1) {
                        System.out.println("Enter product ID:");
                        int productId = scanner.nextInt();
                        System.out.println("Enter product name:");
                        String productName = scanner.next();
                        System.out.println("Enter product price:");
                        double productPrice = scanner.nextDouble();
                        System.out.println("Enter product quantity:");
                        int productQuantity = scanner.nextInt();
                        Product product = new Fashion(productId, productName, productPrice, productQuantity);
                        LocalDB.getLocalDB().addProduct(product);
                        System.out.println("Product added successfully!");
                    }
                    break;
                case 2:
                    System.out.println("Enter product name:");
                    String productName = scanner.next();
                    LocalDB.getLocalDB().removeProduct(productName);
                    System.out.println("Product removed successfully!");
                    break;
                case 3:
                    //go back to main menu
                    break;
            }
        } while (adminChoice != 3);
    }
}

