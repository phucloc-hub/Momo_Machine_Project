package com.example;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MachineImplTest {
    private static class NoPromotion implements PromotionScheme {
        @Override
        public boolean apply(int id) {
            return false;
        }
    }

    private static Map<Integer,Product> productMap = new HashMap<>();

    @BeforeClass
    public static void setup(){
        productMap.put(1,new Product(1,"Coke",10000));
        productMap.put(2,new Product(2,"Pepsi",10000));
        productMap.put(3,new Product(3,"Soda",20000));
    }

    @Test
    public void testCheckout1(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.deposit(10000);
        machine.setProduct(3);
        CheckoutResult checkoutResult = machine.checkout();
        Assert.assertEquals(1,checkoutResult.getQuantity());
        Assert.assertEquals(0,checkoutResult.getChange());

    }

    @Test
    public void testCheckout2(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.setProduct(3);
        CheckoutResult checkoutResult = machine.checkout();
        Assert.assertEquals(0,checkoutResult.getQuantity());
        Assert.assertEquals(10000,checkoutResult.getChange());
    }

    @Test
    public void testCheckout3(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.deposit(10000);
        machine.setProduct(3);
        machine.setProduct(3);
        CheckoutResult checkoutResult = machine.checkout();
        Assert.assertEquals(1,checkoutResult.getQuantity());
        Assert.assertEquals(0,checkoutResult.getChange());
    }

    @Test
    public void testCheckout4(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.setProduct(2);
        machine.setProduct(3);
        CheckoutResult checkoutResult = machine.checkout();
        Assert.assertEquals(0,checkoutResult.getQuantity());
        Assert.assertEquals(10000,checkoutResult.getChange());
    }



    @Test
    public void testCheckout5(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.deposit(10000);
        machine.setProduct(3);
        CheckoutResult checkoutResult = machine.checkout();
        Assert.assertEquals(1,checkoutResult.getQuantity());
        Assert.assertEquals(0,checkoutResult.getChange());

        CheckoutResult checkoutResult2 = machine.checkout();
        Assert.assertEquals(0,checkoutResult2.getQuantity());
        Assert.assertEquals(0,checkoutResult2.getChange());

    }

    @Test
    public void testCheckout6(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.setProduct(2);
        machine.setProduct(3);
        CheckoutResult checkoutResult = machine.checkout();
        Assert.assertEquals(0,checkoutResult.getQuantity());
        Assert.assertEquals(10000,checkoutResult.getChange());

        CheckoutResult checkoutResult2 = machine.checkout();
        Assert.assertEquals(0,checkoutResult2.getQuantity());
        Assert.assertEquals(0,checkoutResult2.getChange());
    }

    @Test
    public void testCancel1(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.setProduct(2);
        machine.setProduct(3);
        Assert.assertEquals(10000,machine.cancel());
    }

    @Test
    public void testCancel2(){
        Machine machine = new MachineImpl(productMap,new NoPromotion());
        machine.deposit(10000);
        machine.deposit(20000);
        machine.setProduct(2);
        machine.setProduct(3);
        Assert.assertEquals(30000,machine.cancel());
        CheckoutResult checkoutResult = machine.checkout();
        Assert.assertEquals(0,checkoutResult.getQuantity());
        Assert.assertEquals(0,checkoutResult.getChange());
    }

}
