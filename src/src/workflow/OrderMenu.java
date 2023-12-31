package src.workflow;

import Models.*;
import Payments.*;
import ShippingMethods.*;

import java.util.Scanner;

public class OrderMenu extends Order {
    private static Order order;

    public OrderMenu(Models.User user, Models.Product product, int quantity, double totalPrice, String address, String phoneNumber, String email, String paymentMethod, String shippingMethod) {
        super(user, product, quantity, totalPrice, address, phoneNumber, email, paymentMethod, shippingMethod);
    }

    public static void OrderMenu(Order order) {
        OrderMenu.order = order;}
    public static void OrderMenu() {
        System.out.println("Welcome to the Order Menu!");
        System.out.println("1. View order");
        System.out.println("2. Remove product from order");
        System.out.println("3. Proceed to payment");
        System.out.println("4. Exit");
        Scanner scanner = null;
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                order.showOrder();
                break;
            case 2:
                System.out.println("Enter product ID:");
                int prodId = scanner.nextInt();
                order.removeProduct(prodId);
                break;
            case 3:
                if(order.getTotalPrice() > 0) {
                    System.out.println("Enter payment method: Press 1 for Credit Card,2 for Paypal");
                    String paymentMethod = scanner.nextLine();
                    System.out.println("Enter shipping method: Press 1 for Expedited,2 for Pickup");
                    String shippingMethod = scanner.nextLine();
                    if(paymentMethod.equals("1")&&shippingMethod.equals("1")){
                        System.out.println("Enter Name on credit card:");
                        String nameOnCreditCard = scanner.nextLine();
                        System.out.println("Enter credit card number:");
                        String creditCardNumber = scanner.nextLine();
                        System.out.println("Enter credit card expiry date:");
                        String creditCardExpiryDate = scanner.nextLine();
                        System.out.println("Enter credit card cvv:");
                        String creditCardCvv = scanner.nextLine();
                        PaymentContext paymentContext = new PaymentContext(new CreditCardPaymentStrategy(nameOnCreditCard,creditCardNumber,creditCardExpiryDate,creditCardCvv));
                        Shipping shipping = new Shipping();
                        shipping.setShippingStrategy(new ExpeditedShipping());
                        paymentContext.pay(order.getTotalPrice());
                        shipping.ship();

                    }
                    else if(paymentMethod.equals("1")&&shippingMethod.equals("2")){
                        System.out.println("Enter Name on credit card:");
                        String nameOnCreditCard = scanner.nextLine();
                        System.out.println("Enter credit card number:");
                        String creditCardNumber = scanner.nextLine();
                        System.out.println("Enter credit card expiry date:");
                        String creditCardExpiryDate = scanner.nextLine();
                        System.out.println("Enter credit card cvv:");
                        String creditCardCvv = scanner.nextLine();
                        PaymentContext paymentContext = new PaymentContext(new CreditCardPaymentStrategy(nameOnCreditCard,creditCardNumber,creditCardExpiryDate,creditCardCvv));
                        Shipping shipping = new Shipping();
                        shipping.setShippingStrategy(new PickupShipping());
                        paymentContext.pay(order.getTotalPrice());
                        shipping.ship();
                    }
                    else if(paymentMethod.equals("2")&&shippingMethod.equals("1")){
                        System.out.println("Enter Mail:");
                        String mail = scanner.nextLine();
                        System.out.println("Enter Password:");
                        String password = scanner.nextLine();
                        PaymentContext paymentContext = new PaymentContext(new PaypalPaymentStrategy(mail,password));
                        Shipping shipping = new Shipping();
                        shipping.setShippingStrategy(new ExpeditedShipping());
                        paymentContext.pay(order.getTotalPrice());
                        shipping.ship();
                    }
                    else if(paymentMethod.equals("2")&&shippingMethod.equals("2")){
                        System.out.println("Enter Mail:");
                        String mail = scanner.nextLine();
                        System.out.println("Enter Password:");
                        String password = scanner.nextLine();
                        PaymentContext paymentContext = new PaymentContext(new PaypalPaymentStrategy(mail,password));
                        Shipping shipping = new Shipping();
                        shipping.setShippingStrategy(new PickupShipping());
                        paymentContext.pay(order.getTotalPrice());
                        shipping.ship();
                    }
                    else{
                        System.out.println("Invalid choice. Please enter a valid option.");
                    }
                    break;}
                case 4:
                    //go back to main menu
                    ReturnPage.ReturnPage();
                    break;
            default:
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}
