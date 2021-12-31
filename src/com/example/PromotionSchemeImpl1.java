package com.example;

import java.util.Map;
import java.util.Random;

public class PromotionSchemeImpl1 implements PromotionScheme {
    private final Map<Integer, Product> productMap;
    private final Random random = new Random();
    private int count = 0;
    private int lastId = 0;
    private int budget;
    private double chance;

    public PromotionSchemeImpl1(Map<Integer, Product> productMap, int budget, double chance) {
        this.productMap = productMap;
        this.budget = budget;
        this.chance = chance;
    }

    @Override
    public boolean apply(int productId) {
        if (lastId == productId) {
            count += 1;
            if (count == 3) {
                count = 0;
                double randomResult = random.nextDouble();
                if (randomResult < chance && budget >= productMap.get(productId).getPrice()) {
                    budget -= productMap.get(productId).getPrice();
                    return true;
                }
            }
        } else {
            lastId = productId;
            count = 1;
        }
        return false;
    }
}
