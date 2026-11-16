package org.example.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Grocery {
    public static ArrayList<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        while (!quit) {
            System.out.println("Secenek giriniz (0: cikis, 1: ekle, 2: cikar):");
            int choice = Integer.parseInt(scanner.nextLine().trim());
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.println("Eklenmesini istediginiz elemanlari giriniz.");
                    addItems(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Cikarilmasini istediginiz elemanlari giriniz.");
                    removeItems(scanner.nextLine());
                    break;
                default:
                    System.out.println("Gecersiz secenek.");
            }
        }
    }

    public static void addItems(String input) {
        for (String item : input.split(",")) {
            String trimmed = item.trim();
            if (!trimmed.isEmpty() && !checkItemsInList(trimmed)) {
                groceryList.add(trimmed);
            }
        }
        printSorted();
    }

    public static void removeItems(String input) {
        for (String item : input.split(",")) {
            String trimmed = item.trim();
            groceryList.remove(trimmed);
        }
        printSorted();
    }

    public static boolean checkItemsInList(String item) {
        return groceryList.contains(item);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println(groceryList);
    }
}
