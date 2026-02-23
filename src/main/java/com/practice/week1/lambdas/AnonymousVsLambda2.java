package com.practice.week1.lambdas;

public class AnonymousVsLambda2 {

    public static void main(String[] args) {

        Calculator anonymousAdd = new Calculator() {
            @Override
            public void calculate(int a, int b) {
                System.out.println("Sum" + (a + b));
            }
        };

        anonymousAdd.calculate(5, 7);

        Calculator lamdaAdd = (a, b) -> System.out.println("Sum " + (a + b));
        lamdaAdd.calculate(7, 9);

        Calculator anonymousMultiply = new Calculator() {
            @Override
            public void calculate(int a, int b) {
                System.out.println("Product " + a * b);
            }
        };

        anonymousMultiply.calculate(5, 6);

        Calculator lamdaMultiply = (a, b) -> System.out.println("Product " + a * b);
        lamdaMultiply.calculate(3, 7);

    }

    interface Calculator {
        void calculate(int a, int b);
    }
}
