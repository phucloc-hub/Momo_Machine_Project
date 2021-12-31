package com.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PromotionSchemeImpl1Test {
    private static Map<Integer,Product> productMap = new HashMap<>();

    @BeforeClass
    public static void setup(){
        productMap.put(1,new Product(1,"Coke",10000));
        productMap.put(2,new Product(2,"Pepsi",10000));
        productMap.put(3,new Product(3,"Soda",20000));
    }


    @Test
    public void test1(){
    PromotionScheme promotionScheme = new PromotionSchemeImpl1(productMap,50000,1D);
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertTrue(promotionScheme.apply(1));

        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertTrue(promotionScheme.apply(1));

        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertTrue(promotionScheme.apply(1));
    }



    @Test
    public void testBudget1(){
        PromotionScheme promotionScheme = new PromotionSchemeImpl1(productMap,20000,1D);
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertTrue(promotionScheme.apply(1));

        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertTrue(promotionScheme.apply(1));

        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
    }

    @Test
    public void testBudget2(){
        PromotionScheme promotionScheme = new PromotionSchemeImpl1(productMap,25000,1D);
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertTrue(promotionScheme.apply(1));

        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertTrue(promotionScheme.apply(1));

        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
    }

    @Test
    public void testChance1(){
        PromotionScheme promotionScheme = new PromotionSchemeImpl1(productMap,25000,0D);
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));

    }

    @Test
    public void testMixProduct1(){
        PromotionScheme promotionScheme = new PromotionSchemeImpl1(productMap,50000,1D);
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(2));
        Assert.assertFalse(promotionScheme.apply(1));

        Assert.assertFalse(promotionScheme.apply(1));
        Assert.assertFalse(promotionScheme.apply(2));
        Assert.assertFalse(promotionScheme.apply(2));
        Assert.assertTrue(promotionScheme.apply(2));

    }
}
