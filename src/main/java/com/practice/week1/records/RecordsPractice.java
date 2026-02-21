package com.practice.week1.records;

public class RecordsPractice {

    public static void main(String[] args) {
        var p1 = new Product("Apple", 100.0, 10);
        System.out.println("Name : " + p1.name);
        System.out.println("Price : " + p1.price);
        System.out.println("Stock : " + p1.stock);
        System.out.println("Full Product : " + p1);

        // Equality by value
        var p2 = new Product("Apple", 100.0, 10);
        System.out.println("Equal : " + p1.equals(p2));//true

        //Test the validation
        try {
            var bad = new Product("", -1, 10);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected error: " + e.getMessage());
        }
    }

    public record Product(String name, double price, int stock) {
        public Product {
            if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
            if (name == null || name.isBlank()) throw new IllegalArgumentException("Name cannot be null");
        }
    }
}
