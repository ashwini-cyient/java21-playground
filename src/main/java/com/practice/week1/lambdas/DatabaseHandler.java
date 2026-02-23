package com.practice.week1.lambdas;

public interface DatabaseHandler {

    void onConnect();

    void onDisconnect();

    void onError();
}
