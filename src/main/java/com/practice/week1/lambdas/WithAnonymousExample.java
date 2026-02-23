package com.practice.week1.lambdas;

public class WithAnonymousExample {

    public static void main(String[] args) {
        ClickHandler printHandler = new ClickHandler() {
            @Override
            public void onClick() {
                System.out.println("--Print--");
            }
        };

        ClickHandler deleteHandler = new ClickHandler() {
            @Override
            public void onClick() {
                System.out.println("--Print--");
            }
        };

        ClickHandler saveHandler = new ClickHandler() {
            @Override
            public void onClick() {
                System.out.println("--Print--");
            }
        };

    }
}
