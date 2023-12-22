package Models;

import Enums.UserRole;

public class User {
    private String UserName;
    private String Password;
    private String Email;
    private String Address;
    private String PhoneNumber;
    private UserRole Role;
    private Order Order;
    private ShoppingCart ShoppingCart;

    public User(String userName, String password, UserRole role) {
        UserName = userName;
        Password = password;
        Role = role;
    }

    public String getEmail() {
        return Email;
    }

    public String getAddress() {
        return Address;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public String getUserName() {
        return UserName;
    }

    public String getPassword() {
        return Password;
    }

    public UserRole getRole() {
        return Role;
    }
}
