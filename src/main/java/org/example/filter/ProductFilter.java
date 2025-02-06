package org.example.filter;

import org.example.domain.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductFilter {
    public static List<Product> findByCategory(List<Product> products, String categoryName) {
        return products.stream()
                .filter(p -> p.getCategory().getName().equalsIgnoreCase(categoryName))
                .collect(Collectors.toList());
    }

    public static List<Product> findByName(List<Product> products, String productName) {
        return products.stream()
                .filter(p -> p.getName().equalsIgnoreCase(productName))
                .collect(Collectors.toList());
    }

    public static List<Product> findByCodProduct(List<Product> products, Long codProduct) {
        return products.stream()
                .filter(p -> p.getCodProduct().equals(codProduct))
                .collect(Collectors.toList());
    }
}
