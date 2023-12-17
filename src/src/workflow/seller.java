package src.workflow;

import LocalDB.LocalDB;
import Models.Electronics;
import Models.Fashion;
import Models.Product;

import java.util.Scanner;

public class seller {
    static void Seller_workflow(Scanner scanner) {
        System.out.println("Press 1 to view products\nPress 2 to add a product\nPress 3 to remove a product");
        int sellerChoice = scanner.nextInt();
        if (sellerChoice == 1) {
            LocalDB.getLocalDB().showProducts();
        } else if (sellerChoice == 2) {
            System.out.println("Enter product category: Press 0 for Electronics,Press 1 for Fashion");
            int category = scanner.nextInt();
            if (category == 0) {
                System.out.println("Enter product name:");
                String productName = scanner.next();
                System.out.println("Enter product price:");
                double productPrice = scanner.nextDouble();
                System.out.println("Enter product quantity:");
                int productQuantity = scanner.nextInt();
                Product product = new Electronics(productName, productPrice, productQuantity);
                LocalDB.getLocalDB().addProduct(product);
                System.out.println("Product added successfully!");
            } else if (category == 1) {
                System.out.println("Enter product name:");
                String productName = scanner.next();
                System.out.println("Enter product price:");
                double productPrice = scanner.nextDouble();
                System.out.println("Enter product quantity:");
                int productQuantity = scanner.nextInt();
                Product product = new Fashion(productName, productPrice, productQuantity);
                LocalDB.getLocalDB().addProduct(product);
                System.out.println("Product added successfully!");
            }
        } else if (sellerChoice == 3) {
            System.out.println("Enter product name:");
            String productName = scanner.next();
            LocalDB.getLocalDB().removeProduct(productName);
            System.out.println("Product removed successfully!");
        }
    }
}
