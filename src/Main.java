import LocalDB.LocalDB;
import java.util.Scanner;

import src.workflow.login;

public class Main {
    public static <User> void main(String[] args) {
        System.out.println("Welcome to the Online Store!");
        System.out.println("Press 1 to login\nPress 2 to register");
        login.login();
    }
}

