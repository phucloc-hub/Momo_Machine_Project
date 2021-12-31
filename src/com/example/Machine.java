package com.example;

public interface Machine {

    void deposit(int amount);

    void setProduct(int id);

    CheckoutResult checkout();

    int cancel();
}
