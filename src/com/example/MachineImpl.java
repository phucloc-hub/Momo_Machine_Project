package com.example;

import java.util.Map;

public class MachineImpl implements Machine {
    private int totalAmount = 0;
    private int productId;
    private final PromotionScheme promotionScheme;
    private final Map<Integer, Product> productMap;

    public MachineImpl(Map<Integer, Product> productMap, PromotionScheme promotionScheme) {
        this.productMap = productMap;
        this.promotionScheme = promotionScheme;
    }

    @Override
    public void deposit(int amount) {
        totalAmount += amount;
    }

    @Override
    public void setProduct(int id) {
        productId = id;
    }

    @Override
    public CheckoutResult checkout() {
        Product product = productMap.get(productId);
        try {
            if (totalAmount < product.getPrice()) {
                return new CheckoutResult(0, totalAmount);
            }
            if (promotionScheme.apply(productId)) {
                return new CheckoutResult(2, totalAmount - product.getPrice());
            }
            return new CheckoutResult(1, totalAmount - product.getPrice());
        } finally {
            totalAmount = 0;
        }
    }

    @Override
    public int cancel() {
        int rs = totalAmount;
        totalAmount = 0;
        return rs;
    }

    public int getTotalAmount() {
        return totalAmount;
    }
}
