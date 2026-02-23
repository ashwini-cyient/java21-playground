package com.practice.week1.lambdas;

public class WithLambdasExample {

    public static void main(String[] args) {
        ClickHandler print = () -> System.out.println("--Print--");
        print.onClick();
        ClickHandler save = () -> System.out.println("--Save--");
        save.onClick();
        ClickHandler delete = () -> System.out.println("--Delete--");
        delete.onClick();

    }
}
