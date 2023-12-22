package Models;

public class Inventory {
    private Product[] Products;

    public Inventory(Product[] products) {
        Products = products;
    }

    public boolean purchaseProduct(Product product) {
        for (int i = 0; i < Products.length; i++) {
            if (Products[i].getName().equals(product.getName())) {
                if (Products[i].getQuantity() > 0) {
                    Products[i].setQuantity(Products[i].getQuantity() - 1);
                    return true;
                }
            }
        }
        return false;
    }
    public void updateStock(Product product) {
        for (int i = 0; i < Products.length; i++) {
            if (Products[i].getName().equals(product.getName())) {
                Products[i].setQuantity(Products[i].getQuantity() + product.getQuantity());
            }
        }
    }
    public void showProducts() {
        for (int i = 0; i < Products.length; i++) {
            System.out.println(Products[i].getName() + " " + Products[i].getPrice() + " " + Products[i].getQuantity());
        }
    }
    public boolean isOutOfStock(Product product) {
        for (int i = 0; i < Products.length; i++) {
            if (Products[i].getName().equals(product.getName())) {
                if (Products[i].getQuantity() == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
