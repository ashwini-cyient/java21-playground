package com.practice.week1.records;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

public class LombokPractice {

    public static void main(String[] args) {

        // Example 1: Getters/Setters
        Product product = new Product();
        product.setName("Laptop");
        product.setPrice(999.99);
        System.out.println("Product: " + product.getName() + " - $" + product.getPrice());

        // Example 2: Constructor (Lombok generated this!)
        UserService service = new UserService("jdbc:postgresql://localhost/db", 10);
        service.connect();

        // Example 3: Builder
        OrderRequest order = OrderRequest.builder()
                .productId("SKU-123")
                .quantity(5)
                .address("456 Elm St")
                .build();
        System.out.println("Ordered " + order.quantity + " of " + order.productId);

        // Example 4: Logging
        PaymentProcessor processor = new PaymentProcessor();
        processor.processPayment(150.00);


    }


    //Example1 : Simple getters and setters
    @Getter
    @Setter
    public static class Product {
        private String name;
        private double price;

    }

    //Example2 : Constructor injection pattern
    @RequiredArgsConstructor
    public static class UserService {
        private final String databaseUrl;   //final = injected via constructor
        private final int maxConnections;   //final = injected via constructor

        public void connect() {
            System.out.println("Connecting to database..." + databaseUrl + "with max" + maxConnections);
        }
    }

    //Example3 : Builder Pattern
    @Builder
    public static class OrderRequest {
        private final String productId;
        private int quantity;
        private String address;

    }

    // ── Example 4: Logging ──
    @Slf4j
    public static class PaymentProcessor {
        public void processPayment(double amount) {
            log.info("Processing payment of ${}", amount);
            log.warn("This is a warning message");
            log.error("This is an error message");
        }
    }
}