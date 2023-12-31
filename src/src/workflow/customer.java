package src.workflow;


import java.util.Scanner;
import LocalDB.LocalDB;
import src.workflow.OrderMenu;
import src.workflow.ProductMenu;
import src.workflow.ReturnPage;
import src.workflow.ShoppingcartMenu;

import java.util.Scanner;

public class customer {
    static void Customer_workflow(Scanner scanner) {
        int customerChoice;
        do {
            System.out.println("Press 1 to view products\nPress 2 to view shopping cart\nPress 3 to view orders\nPress 4 to exit");
            customerChoice = scanner.nextInt();
            switch (customerChoice) {
                case 1:
                    ProductMenu.ProductMenu();
                    break;
                case 2:
                    ShoppingcartMenu.ShoppingcartMenu();
                    break;
                case 3:
                    OrderMenu.OrderMenu();
                    break;
                case 4:
                    //go back to main menu
                    ReturnPage.ReturnPage();
                    break;
            }
        } while (customerChoice != 4);

    }
}
