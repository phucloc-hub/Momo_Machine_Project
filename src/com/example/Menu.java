package com.example;

import java.util.Scanner;

public class Menu {
    String hint[];
    int n = 0;

    public Menu(int size) {
        if (size < 1) size = 10;
        hint = new String[size];
    }

    public void add(String ahint) {
        if (ahint.length() > n) hint[n++] = ahint;
    }

    public int getChoice() {
        int result = 0;
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.println((i + 1) + "-" + hint[i]);
            }
            System.out.println("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            result = Integer.parseInt(sc.nextLine());
        }
        return result;
    }
}
