package src.workflow;

import LocalDB.LocalDB;
import Models.Product;

import java.util.Scanner;

public class customer {
    static void Customer_workflow(Scanner scanner) {
        System.out.println("Press 1 to view products\nPress 2 to buy a product");
        int customerChoice = scanner.nextInt();
        if (customerChoice == 1) {
            LocalDB.getLocalDB().showProducts();
        } else if (customerChoice == 2) {
            System.out.println("Enter product name:");
            String productName = scanner.next();
            Product product = LocalDB.getLocalDB().getProduct(productName);
            if (product != null) {
                System.out.println("Enter product quantity:");
                int productQuantity = scanner.nextInt();
                if (product.getQuantity() >= productQuantity) {
                    System.out.println("Total price: " + product.getPrice() * productQuantity);
                    LocalDB.getLocalDB().buyProduct(productName, productQuantity);
                    System.out.println("Product bought successfully!");
                } else {
                    System.out.println("Not enough quantity!");
                }
            } else {
                System.out.println("Product not found!");
            }
        }
    }
}
