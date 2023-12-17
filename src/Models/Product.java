package Models;

import Enums.Categories;

public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    private Categories category;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name.length() < 3) {
            throw new IllegalArgumentException("Name must be at least 3 characters long!");
        }
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Price must be a positive number!");
        }
        this.price = price;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must be a positive number!");
        }
        this.quantity = quantity;
    }
    public Categories getCategory() {
        return category;
    }
    public void setCategory(Categories category) {
        this.category = category;
    }
}
