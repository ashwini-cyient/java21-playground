package com.practice.week1.lambdas;

import java.time.LocalDate;
import java.util.function.*;

public class FunctionalInterfacesExercise {
    public static void main(String[] args) {
        //Task 1 : Create a predicate that tests if a number is positive
        Predicate<Integer> predicate = (n) -> n > 0 ? true : false;
        System.out.println(predicate.test(5));
        System.out.println(predicate.test(-5));


        //Task 2  : Create a function that converts Celsius to Fahrenheit
        Function<Double, Double> function = (celsius) -> celsius * 9 / 5 + 32;
        System.out.println(function.apply(100.5));
        System.out.println(function.apply(0.5));

        //Task 3 : Create a consumer that prints a number square
        Consumer<Integer> consumer = (number) -> System.out.println(number * number);
        consumer.accept(5);
        consumer.accept(5);

        //Task 4 : Create a supplier that returns the current year
        Supplier<Integer> supplier = () -> LocalDate.now().getYear();
        System.out.println(supplier.get());

        //Task 5 : Create a BiFunction that finds that maximum of two numbers
        BiFunction<Integer, Integer, Integer> biFunction = (number1, number2) -> number1 > number2 ? number1 : number2;
        System.out.println(biFunction.apply(10, 20));  // Should print: 20
        System.out.println(biFunction.apply(50, 30));  // Should print: 50


    }
}
