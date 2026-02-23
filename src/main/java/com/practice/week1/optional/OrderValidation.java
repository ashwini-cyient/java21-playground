package com.practice.week1.optional;

import java.util.Map;
import java.util.Optional;

public class OrderValidation {

    static Map<String, User> users = Map.of(
            "1", new User("1", "Alice", "alice@shop.com"),
            "2", new User("2", "Bob", "bob@shop.com"),
            "3", new User("3", "Carol", null),  // No email
            "4", new User("4", "Dave", "dave-invalid-email")  // Invalid email (no @)
    );

    public static void main(String[] args) {
        // Success cases
        System.out.println(getValidatedEmail("1"));  // Should print: ALICE@SHOP.COM
        System.out.println(getValidatedEmail("2"));  // Should print: BOB@SHOP.COM

        // Error cases
        try {
            getValidatedEmail("99");  // User not found
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            getValidatedEmail("3");  // No email
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            getValidatedEmail("4");  // Invalid format
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String getValidatedEmail(String userId) {
        return Optional.ofNullable(users.get(userId))
                .flatMap(user -> user.getEmail())
                .filter(email -> email.contains("@"))
                .map(email -> email.toUpperCase())
                .orElseThrow(() -> new IllegalArgumentException("Cannot get valid email for user: " + userId));
        //    ↑
        //  This returns the String (or throws)
    }

    public record User(String id, String name, String emailAddress) {
        // Returns Optional because email might be null
        public Optional<String> getEmail() {
            return Optional.ofNullable(emailAddress);
        }
    }


}
