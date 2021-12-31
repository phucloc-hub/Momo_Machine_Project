package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Manager {

    private static Map<Integer, Product> productMap = new HashMap<>();
    private static final int BUDGET = 50000;
    private static final double CHANCE = 0.1D;

    public static void main(String[] args) {

        productMap.put(1, new Product(1, "Coke", 10000));
        productMap.put(2, new Product(2, "Pepsi", 10000));
        productMap.put(3, new Product(3, "Soda", 20000));

        Menu menu = new Menu(4);
        menu.add("Add Money");
        menu.add("Choose Product");
        menu.add("Check out");
        menu.add("Cancel");

        Scanner sc = new Scanner(System.in);

        int choice;
        PromotionScheme promotionScheme = new PromotionSchemeImpl1(productMap, BUDGET, CHANCE);
        MachineImpl machine = new MachineImpl(productMap, promotionScheme);
        do {
            System.out.println("Your balance: " + (machine.getTotalAmount()));
            choice = menu.getChoice();
            switch (choice) {

                case 1:
                    System.out.println("Enter your money: ");
                    machine.deposit(Integer.parseInt(sc.nextLine()));
                    break;
                case 2:
                    System.out.println("Choose a product: ");
                    for (Product product : productMap.values()
                    ) {
                        System.out.println(product.getId() + " - " + product.getName());
                    }
                    machine.setProduct(Integer.parseInt(sc.nextLine()));
                    break;
                case 3:
                    CheckoutResult checkoutResult = machine.checkout();
                    if (checkoutResult.getChange() > 0) {
                        System.out.println("Here your chance: " + checkoutResult.getChange());
                    }
                    int quantity = checkoutResult.getQuantity();
                    if (quantity == 0) {
                        System.out.println("Please deposit more money");
                    } else if (quantity == 1) {
                        System.out.println("Here your drink");
                    } else {
                        System.out.println("Congratulation. You got a drink for free");
                        System.out.println("Here your drink");
                    }
                    break;
                case 4:
                    System.out.println("Receive your money back:  " + machine.cancel());
            }
        } while (choice >= 1 && choice <= 3);


    }
}
