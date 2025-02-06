package org.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long codProduct;
    private String name;
    private float price;
    private Category category;
    private static Long count = 1L;

    public Product(float price, String name, Category category) {
        this.codProduct = count++;
        this.price = price;
        this.name = name;
        this.category = category;
    }
}
