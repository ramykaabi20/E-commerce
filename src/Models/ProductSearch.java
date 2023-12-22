package Models;

import java.util.ArrayList;
import java.util.List;

public class ProductSearch extends Product {
    private List<Product> products;

    public List<Product> searchByName(String keyword) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase())) {
                // Match found, add product to the result list
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                // Match found, add product to the result list
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public List<Product> filterByCategory(String category) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                // Match found, add product to the result list
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public List<Product> filterByAvailability() {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getQuantity() > 0) {
                // Match found, add product to the result list
                matchingProducts.add(product);
            }
        }
        return matchingProducts;
    }

    public List<Product> searchAndFilter(String keyword, double minPrice, double maxPrice, String category) {
        List<Product> matchingProducts = new ArrayList<>();

        for (Product product : products) {
            if (product.getName().toLowerCase().contains(keyword.toLowerCase()) &&
                    product.getPrice() >= minPrice && product.getPrice() <= maxPrice &&
                    product.getCategory().equals(category)) {
                matchingProducts.add(product);
            }
            return matchingProducts;
        }
        return matchingProducts;
    }
}