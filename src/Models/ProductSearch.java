package Models;


import java.util.HashMap;

public class ProductSearch extends Product {
    private HashMap<String,Product> products;

    public ProductSearch() {
        products = new HashMap<>();

    }

    public HashMap<String,Product> searchByName(String keyword) {
        HashMap<String,Product> matchingProducts = new HashMap<>();

        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                // Match found, add product to the result list
                matchingProducts.put(product.getName(), product);
            }
        }
        return matchingProducts;
    }

    public HashMap<String,Product> filterByPriceRange(double minPrice, double maxPrice) {
        HashMap<String,Product> matchingProducts = new HashMap<>();

        for (Product product : products.values()) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                // Match found, add product to the result list
                matchingProducts.put(product.getName(), product);
            }
        }
        return matchingProducts;
    }

    public HashMap<String,Product> filterByCategory(String category) {
        HashMap<String,Product> matchingProducts = new HashMap<>();

        for (Product product : products.values()) {
            if (product.getCategory().equals(category)) {
                // Match found, add product to the result list
                matchingProducts.put(product.getName(), product);
            }
        }
        return matchingProducts;
    }

    public HashMap<String,Product> filterByAvailability() {
        HashMap<String,Product> matchingProducts = new HashMap<>();

        for (Product product : products.values()) {
            if (product.getQuantity() > 0) {
                // Match found, add product to the result list
                matchingProducts.put(product.getName(), product);
            }
        }
        return matchingProducts;
    }

    public HashMap<String,Product> searchAndFilter(String keyword, double minPrice, double maxPrice, String category) {
        HashMap<String,Product> matchingProducts = new HashMap<>();

        for (Product product : products.values()) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) &&
                    product.getPrice() >= minPrice && product.getPrice() <= maxPrice &&
                    product.getCategory().equals(category)) {
                matchingProducts.put(product.getName(), product);
            }
            return matchingProducts;
        }
        return matchingProducts;
    }
}