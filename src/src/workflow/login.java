package src.workflow;

import Enums.*;
import LocalDB.LocalDB;
import Models.*;

import java.util.Scanner;

public class login {

    public static void login() {
        System.out.println("Press 1 to login\nPress 2 to register");
        Scanner scanner = new Scanner(System.in);
        LocalDB localDB = LocalDB.getLocalDB();
        localDB.addUser(new User("admin", "admin", UserRole.ADMIN));
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
        if (choice==2){
            System.out.println("Enter your username:");
            String username = scanner.next();
            System.out.println("Enter your password:");
            String password = scanner.next();
            System.out.println("Enter your role:Press 1 for CUSTOMER,Press 2 for SELLER");
            int role = scanner.nextInt();
            if (role == 1) {
                if(localDB.getUser(username,password)!=null){
                    System.out.println("User already exists!");
                    return;
                }
                else{
                User cust = new User(username, password,UserRole.CUSTOMER);
                localDB.addUser(cust);
                System.out.println("User added successfully!");
                System.out.println("Welcome " + cust.getUserName() + "!");
                customer.Customer_workflow(scanner);
                }
            } else if (role == 2) {
                if (localDB.getUser(username,password)!=null){
                    System.out.println("User already exists!");
                    return;
                }
                else{
                User sel = new User(username, password,UserRole.SELLER);
                localDB.addUser(sel);
                System.out.println("User added successfully!");
                System.out.println("Welcome " + sel.getUserName() + "!");
                seller.Seller_workflow(scanner);
                }
            }
            else{
                System.out.println("Invalid role!");
            }
        }
    }

}
