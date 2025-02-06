package org.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category {
    private Long codCategory;
    private String name;
    private static Long count = 1L;

    public Category(String name) {
        this.codCategory = count++;
        this.name = name;
    }
}
