package LocalDB;

import Models.Product;
import Models.User;

import java.util.HashMap;
import java.util.HashSet;

public final class LocalDB {
    private static LocalDB instance = null;
    private static HashMap<String, User> users = new HashMap<String, User>();
    private static HashMap<String, Product> products = new HashMap<String, Product>();

    private LocalDB() {
    }
    public static LocalDB getLocalDB() {
        if (instance == null) {
            instance = new LocalDB();
        }
        return instance;
    }
    public static User getUser(String username, String password) {
        var user = LocalDB.users.get(username);
        if (user == null) {
            return null;
        }
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
    public static void addUser(User user) {
        users.put(user.getUserName(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    public void removeProduct(String productName) {
        products.remove(productName);
    }

    public void showProducts() {
        for (var product : products.values()) {
            System.out.println(product.getName() + " " + product.getPrice() + " " + product.getQuantity());
            System.out.println(product.getAverageRating());
            product.displayReviews();
        }
    }
    public Product getProduct(String productName) {
        var product = products.get(productName);
        if (product == null) {
            return null;
        }
        return product;
    }

    public void buyProduct(String productName, int productQuantity) {
        var product = products.get(productName);
        if (product == null) {
            System.out.println("Product not found!");
            return;
        }
        if (product.getQuantity() < productQuantity) {
            System.out.println("Not enough quantity!");
            return;
        }
        product.setQuantity(product.getQuantity() - productQuantity);
    }

    public boolean isOutOfStock(Product product) {
        var productInDB = products.get(product.getName());
        if (productInDB == null) {
            return true;
        }
        return productInDB.getQuantity() == 0;
    }
}
