package Models;

import Enums.UserRole;

public class User {
    private String UserName;
    private String Password;
    private UserRole Role;

    public User(String userName, String password, UserRole role) {
        UserName = userName;
        Password = password;
        Role = role;
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
