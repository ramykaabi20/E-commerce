package Models;

public class ShoppingCart {
    private Product[] products;
    private User user;
    private int count;

    public ShoppingCart() {
        this.products = new Product[10];
        this.count = 0;
    }

    public void addProduct(Product product) {
        if (this.count == this.products.length) {
            Product[] newProducts = new Product[this.products.length * 2];
            for (int i = 0; i < this.products.length; i++) {
                newProducts[i] = this.products[i];
            }
            this.products = newProducts;
        }
        this.products[this.count] = product;
        this.count++;
    }

    public void removeProduct(Product product) {
        int index = -1;
        for (int i = 0; i < this.count; i++) {
            if (this.products[i].getName().equals(product.getName())) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new IllegalArgumentException("Product not found!");
        }
        for (int i = index; i < this.count - 1; i++) {
            this.products[i] = this.products[i + 1];
        }
        this.count--;
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (int i = 0; i < this.count; i++) {
            totalPrice += this.products[i].getPrice();
        }
        return totalPrice;
    }

    public Order checkout() {
        this.products = new Product[10];
        this.count = 0;
        return new Order(user, null, 0, this.getTotalPrice(), null, null, null, null, null);
    }
}
