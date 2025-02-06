package org.example.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salesman {
    private Long codSalesman;
    private String name;
    private float salary;
    private static Long count = 1L;

    public Salesman(String name, float salary) {
        this.codSalesman = count++;
        this.name = name;
        this.salary = salary;
    }
}
