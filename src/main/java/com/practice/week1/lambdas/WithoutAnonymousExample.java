package com.practice.week1.lambdas;

public class WithoutAnonymousExample {
    public static void main(String[] args) {

        ClickHandler printHandler = new PrintHandler();
        printHandler.onClick();

        ClickHandler saveHandler = new SaveHandler();
        saveHandler.onClick();

        ClickHandler deleteHandler = new DeleteHandler();
        deleteHandler.onClick();
    }

}
