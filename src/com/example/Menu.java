package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private List<String> hints = new ArrayList<>();

    public void add(String ahint) {
        hints.add(ahint);
    }

    public int getChoice() {
        int result = 0;
        if (!hints.isEmpty()) {
            for (int i = 0; i < hints.size(); i++) {
                System.out.println((i + 1) + "-" + hints.get(i));
            }
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            result = Integer.parseInt(sc.nextLine());
        }
        return result;
    }
}
