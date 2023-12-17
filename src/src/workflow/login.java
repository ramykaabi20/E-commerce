package src.workflow;

import Enums.UserRole;
import LocalDB.LocalDB;

import java.util.Scanner;

public class login {
    
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        LocalDB localDB = LocalDB.getLocalDB();
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Enter your username:");
            String username = scanner.next();
            System.out.println("Enter your password:");
            String password = scanner.next();
            var user = localDB.getUser(username, password);
            if (user != null) {
                System.out.println("Welcome " + user.getUserName() + "!");
                if (user.getRole() == UserRole.ADMIN) {
                    admin.ADMIN_Workflow(scanner);
                } else if (user.getRole() == UserRole.CUSTOMER) {
                    customer.Customer_workflow(scanner);
                } else if (user.getRole() == UserRole.SELLER) {
                    seller.Seller_workflow(scanner);
                }
            }
        }
    }

}
