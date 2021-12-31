package com.example;

public class CheckoutResult {


    private final int quantity;
    private final int change;

    public CheckoutResult(int quantity, int change) {
        this.quantity = quantity;
        this.change = change;
    }


    public int getChange() {
        return change;
    }

    public int getQuantity() {
        return quantity;
    }
}
