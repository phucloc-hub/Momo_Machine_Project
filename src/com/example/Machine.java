package com.example;

public interface Machine {

    void deposit(int amount);

    int getBalance();

    void setProduct(int id);

    CheckoutResult checkout();

    int cancel();
}
