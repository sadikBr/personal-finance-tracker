package com.brahimsadik.personalFinanceTracker;

import com.brahimsadik.personalFinanceTracker.displayManager.DisplayManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        DisplayManager.printApplicationName();
        while (choice == 0) {
            DisplayManager.displayMenuOptions();
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    DisplayManager.printSpacer();
                    System.out.println("This will be implemented soon.");
                    DisplayManager.printSpacer();
                    break;
                case 7:
                    DisplayManager.printSpacer();
                    System.out.println("Everything is saved. See you later!");
                    DisplayManager.printSpacer();
                    break;
                default:
                    DisplayManager.printSpacer();
                    System.out.println("Please enter a valid choice.");
                    DisplayManager.printSpacer();
                    choice = 0;
                    break;
            }
        }
    }
}