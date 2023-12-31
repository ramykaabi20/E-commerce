package src.workflow;

import Models.Order;
import Models.Product;
import Models.ShoppingCart;
import Models.User;

import java.util.Scanner;

public class ShoppingcartMenu extends ShoppingCart {
    private Product product;
    private User customer;
    public void ShoppingcartMenu(Product product,User customer) {
        this.product = product;
        this.customer = customer;
    }


    public static void ShoppingcartMenu() {

        System.out.println("Welcome to the Shopping Cart Menu!");
        System.out.println("1. Add item to cart");
        System.out.println("2. Remove item from cart");
        System.out.println("3. View cart");
        System.out.println("4. Checkout");
        System.out.println("5. Exit");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter product id:");
                int prodid = scanner.nextInt();
                System.out.println("Enter quantity:");
                int productQuantity = scanner.nextInt();
                ShoppingCart.addProduct(prodid, productQuantity);
                break;
            case 2:
                System.out.println("Enter product ID:");
                int prodId = scanner.nextInt();
                ShoppingCart.removeProduct(prodId);
                break;
            case 3:
                ShoppingCart.viewCart();
                break;
            case 4:
                Order checkout = ShoppingCart.checkout();
                OrderMenu.OrderMenu(checkout);
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
