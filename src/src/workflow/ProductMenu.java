package src.workflow;

import Models.Order;
import Models.Product;
import Models.ProductSearch;
import Models.ShoppingCart;
import LocalDB.LocalDB;
import java.util.Scanner;

public class ProductMenu {
    public static void ProductMenu(){
        System.out.println("Press 1 to view products\nPress 2 to add a product to cart\nPress 3 to remove a product from cart\nPress 4 to checkout\nPress 5 to exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Products available:");
                LocalDB.getLocalDB().showProducts();
                System.out.println("Do you want to filter your search? Press 1 for yes,Press 2 for no");
                int filterChoice = scanner.nextInt();
                if(filterChoice==1){
                    System.out.println("Press 0 to search by name\nPress 1 to filter by category\nPress 2 to filter by price");
                    int searchChoice = scanner.nextInt();
                    if (searchChoice == 0) {
                        ProductSearch filter = new ProductSearch();
                        System.out.println("Enter product name:");
                        String productName = scanner.next();
                        filter.searchByName(productName);}
                    else if (searchChoice == 1) {
                        ProductSearch filter = new ProductSearch();
                        System.out.println("Enter product category:");
                        String productCategory = scanner.next();
                        filter.filterByCategory(productCategory);
                }   else if (searchChoice == 2) {
                        ProductSearch filter = new ProductSearch();
                        System.out.println("Enter minimum price:");
                        double minPrice = scanner.nextDouble();
                        System.out.println("Enter maximum price:");
                        double maxPrice = scanner.nextDouble();
                        filter.filterByPriceRange(minPrice, maxPrice);
                    }
                }
                break;
            case 2:
                System.out.println("Enter product id:");
                int prodId = scanner.nextInt();
                System.out.println("Enter quantity:");
                int productQuantity = scanner.nextInt();
                ShoppingCart.addProduct(prodId, productQuantity);
                break;
            case 3:
                System.out.println("Enter product ID:");
                int prodId1 = scanner.nextInt();
                ShoppingCart.removeProduct(prodId1);
                break;
            case 4:
                Order checkout = ShoppingCart.checkout();
                break;
            case 5:
                //go back to main menu
                ReturnPage.ReturnPage();
                break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }

}
