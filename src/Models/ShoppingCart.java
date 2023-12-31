package Models;
import LocalDB.LocalDB;
public class ShoppingCart {
    private static Product[] products;
    private static User user;
    private static int count;

    public ShoppingCart() {
        this.products = new Product[10];
        this.count = 0;
    }

    protected static void viewCart() {
        System.out.println("Your cart contains:");
        for (int i = 0; i < count; i++) {
            System.out.println(products[i].getName() + " " + products[i].getPrice());
        }
    }

    public static void addProduct(int ProductId, int quantity) {
        Product product = LocalDB.getProduct(String.valueOf(ProductId));
        if (product == null) {
            throw new IllegalArgumentException("Product not found!");
        }
        if (product.getQuantity() < quantity) {
            throw new IllegalArgumentException("Not enough quantity!");
        }
        product.setQuantity(product.getQuantity() - quantity);
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId() == ProductId) {
                products[i].setQuantity(products[i].getQuantity() + quantity);
                return;
            }
        }
        if (count == products.length) {
            Product[] newProducts = new Product[products.length * 2];
            for (int i = 0; i < count; i++) {
                newProducts[i] = products[i];
            }
            products = newProducts;
        }
        products[count++] = product;

    }

    public static void removeProduct(int ProductId) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (products[i].getProductId() == ProductId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Product not found!");
        }
        for (int i = index; i < count - 1; i++) {
            products[i] = products[i + 1];
        }
        count--;
    }

    public static double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < count; i++) {
            totalPrice += products[i].getPrice();
        }
        return totalPrice;
    }

    public static Order checkout() {
        products = new Product[10];
        count = 0;
        return new Order(user, null, 0, getTotalPrice(), null, null, null, null, null);
    }
}
