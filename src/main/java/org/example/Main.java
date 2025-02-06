package org.example;

import org.example.domain.Category;
import org.example.domain.Product;
import org.example.domain.Sale;
import org.example.domain.Salesman;
import org.example.filter.ProductFilter;

import java.util.List;

import java.util.Scanner;
import java.time.LocalDate;


import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        List<Product> products = initializeProducts();
        List<Salesman> salesmen = initializeSalesmen();

        System.out.println("¡Bienvenido a la tienda!");
        Salesman selectedSalesman = selectSalesman(salesmen);
        Sale sale = new Sale(LocalDate.now(), selectedSalesman);

        processSale(products, sale);

        sale.closeSale();
        System.out.printf("\nVenta cerrada.\nTotal: %.2f\nComisión: %.2f\n", sale.getTotalAmount(), sale.getCommission());
    }

    private static List<Product> initializeProducts() {
        return Arrays.asList(
                new Product(1000.0f, "CocaCola", new Category("Bebida")),
                new Product(500.0f, "Fanta", new Category("Bebida")),
                new Product(1.0f, "Manzana", new Category("Comida"))
        );
    }

    private static List<Salesman> initializeSalesmen() {
        return Arrays.asList(
                new Salesman("Juan Pérez", 2000.0f),
                new Salesman("Ana Gómez", 2200.0f)
        );
    }

    private static Salesman selectSalesman(List<Salesman> salesmen) {
        System.out.println("Selecciona un vendedor:");
        for (int i = 0; i < salesmen.size(); i++) {
            System.out.println((i + 1) + ". " + salesmen.get(i).getName());
        }
        return salesmen.get(getValidInput( 1, salesmen.size()) - 1);
    }

    private static void processSale(List<Product> products, Sale sale) {
        boolean addingProducts = true;

        while (addingProducts) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Buscar por categoría");
            System.out.println("2. Buscar por nombre");
            System.out.println("3. Buscar por ID");
            System.out.println("4. Finalizar venta");

            switch (getValidInput(1, 4)) {
                case 1 -> addProductToSale(sale, ProductFilter.findByCategory(products, getUserInput("Nombre de la categoría: ")));
                case 2 -> addProductToSale(sale, ProductFilter.findByName(products, getUserInput("Nombre del producto: ")));
                case 3 -> addProductToSale(sale, ProductFilter.findByCodProduct(products, Long.parseLong(getUserInput("ID del producto: "))));
                case 4 -> addingProducts = false;
            }
        }
    }

    private static void addProductToSale(Sale sale, List<Product> foundProducts) {
        if (foundProducts.isEmpty()) {
            System.out.println("No se encontraron productos.");
            return;
        }

        System.out.println("Productos encontrados:");
        for (int i = 0; i < foundProducts.size(); i++) {
            Product p = foundProducts.get(i);
            System.out.printf("%d. %s - %.2f (%s)\n", i + 1, p.getName(), p.getPrice(), p.getCategory().getName());
        }

        Product selectedProduct = foundProducts.get(getValidInput(1, foundProducts.size()) - 1);
        int quantity = getValidInput(1, Integer.MAX_VALUE, "Cantidad: ");
        sale.addProduct(selectedProduct, quantity);
    }

    private static int getValidInput(int min, int max) {
        return getValidInput(min, max, "Opción: ");
    }

    private static int getValidInput(int min, int max, String message) {
        int input;
        while (true) {
            try {
                System.out.print(message);
                input = Integer.parseInt(scanner.nextLine());
                if (input >= min && input <= max) return input;
            } catch (NumberFormatException ignored) {}
            System.out.println("Entrada inválida, intenta de nuevo.");
        }
    }

    private static String getUserInput(String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine().trim();
        } while (input.isEmpty());
        return input;
    }
}

