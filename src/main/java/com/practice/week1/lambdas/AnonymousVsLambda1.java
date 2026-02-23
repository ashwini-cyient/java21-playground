package com.practice.week1.lambdas;

public class AnonymousVsLambda1 {

    public static void main(String[] args) {
        //Anonymous example
        Greeter anonymous = new Greeter() {
            @Override
            public void greet(String name) {
                System.out.println("Hello " + name);
            }
        };

        anonymous.greet("Manoj");

        //Lambda example

        Greeter lambda = (name) -> System.out.println("Hello " + name);
        lambda.greet("Manoj");


    }

    interface Greeter {
        void greet(String name);
    }

}
