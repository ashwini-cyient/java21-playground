package com.practice.week1.optional;

import java.util.Optional;

public class OptionalExercises {

    public static void main(String[] args) {
        System.out.println(getUserNameOrDefault("1"));   // Should print: Alice
        System.out.println(getUserNameOrDefault("2"));   // Should print: Bob
        try {
            System.out.println(getUserNameOrFail("99"));  // Should throw exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught: " + e.getMessage());  // Should print: Caught: User not found: 99
        }
        printUserIfExists("1");   // Should print: Found user: Alice
        printUserIfExists("2");   // Should print: Found user: Bob
        printUserIfExists("99");  // Should print nothing

        System.out.println(getUserEmailDomain("1"));   // Should print: Optional[alice@company.com]
        System.out.println(getUserEmailDomain("2"));   // Should print: Optional[bob@company.com]
        System.out.println(getUserEmailDomain("99"));  // Should print: Optional

        System.out.println(findUserEmail("1"));   // Should print: Optional[alice@example.com]
        System.out.println(findUserEmail("2"));   // Should print: Optional[bob@example.com]
        System.out.println(findUserEmail("3"));   // Should print: Optional.empty
        System.out.println(findUserEmail("99"));  // Should print: Optional.empty

    }


    public static Optional<String> findUserById(String userId) {
        Optional<String> result = Optional.empty();
        if (userId.equals("1")) {
            result = Optional.of("Alice");
            //Alice
        } else if (userId.equals("2")) {
            result = Optional.of("Bob");
        }
        return result;
    }

    public static String getUserNameOrDefault(String userId) {
        Optional<String> user = findUserById(userId);
        return user.orElse("Unknown User");
    }

    public static String getUserNameOrFail(String userId) {
        Optional<String> user = findUserById(userId);
        return user.orElseThrow(() -> new IllegalArgumentException("User not found: " + userId));
    }

    public static void printUserIfExists(String userId) {
        Optional<String> user = findUserById(userId);
        user.ifPresent(value -> System.out.println("Found user : " + value));


    }

    public static Optional<String> getUserEmailDomain(String userId) {
        Optional<String> user = findUserById(userId);
        return user.map(value -> value.toLowerCase() + "@gmail.com");
    }

    public static Optional<String> findUserEmail(String userId) {
        String email = null;
        if (userId.equals("1")) {
            email = "alice@gmail.com";
        } else if (userId.equals("2")) {
            email = "bob@gmail.com";
        } else if (userId.equals("3")) {
            email = null;
        }

        return Optional.ofNullable(email);

    }

}
