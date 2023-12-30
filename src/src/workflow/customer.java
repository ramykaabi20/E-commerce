package src.workflow;

import LocalDB.LocalDB;
import Models.*;
import java.util.HashMap;

import java.util.Scanner;

public class customer {
    static void Customer_workflow(Scanner scanner) {
        System.out.println("Press 1 to view products\nPress 2 to buy a product");
        int customerChoice = scanner.nextInt();
        if (customerChoice == 1) {
            System.out.println("Products available:");
            LocalDB.getLocalDB().showProducts();
            System.out.println("Do you want to filter your search? Press 1 for yes,Press 2 for no");
            int filterChoice = scanner.nextInt();
            System.out.println("Press 0 to search by name\nPress 1 to filter by category\nPress 2 to filter by price");
            int searchChoice = scanner.nextInt();
            if (searchChoice == 0) {
                ProductSearch filter = new ProductSearch();
                System.out.println("Enter product name:");
                String productName = scanner.next();
                filter.searchByName(productName);
            } else if (searchChoice == 1) {
                ProductSearch filter = new ProductSearch();
                System.out.println("Enter product category:");
                String productCategory = scanner.next();
                filter.filterByCategory(productCategory);
            } else if (searchChoice == 2) {
                ProductSearch filter = new ProductSearch();
                System.out.println("Enter minimum price:");
                double minPrice = scanner.nextDouble();
                System.out.println("Enter maximum price:");
                double maxPrice = scanner.nextDouble();
                filter.filterByPriceRange(minPrice, maxPrice);
            }
        } else if (customerChoice == 2) {
            System.out.println("Enter product name:");
            String productName = scanner.next();
            Product product = LocalDB.getLocalDB().getProduct(productName);
            if (product != null) {
                if (LocalDB.getLocalDB().isOutOfStock(product)) {
                    System.out.println("Product is out of stock!");
                } else {
                    System.out.println("Enter quantity:");
                    int productQuantity = scanner.nextInt();
                    if (productQuantity > product.getQuantity()) {
                        System.out.println("Product quantity is not available!");
                    } else {
                        product.setQuantity(productQuantity);
                        LocalDB.getLocalDB().buyProduct(productName, productQuantity);
                        System.out.println("Product purchased successfully!");
                    }
                }
            } else {
                System.out.println("Product not found!");



            }
        }
    }
}
