package com.brahimsadik.personalFinanceTracker.displayManager;

public class DisplayManager {

    public static void printApplicationName() {
        System.out.println("============== Personal Finance Tracker ==============");
    }

    public static void displayMenuOptions() {
        String menu = """
                1. Add Income
                2. Add Expense
                3. View All Transactions
                4. View Summary
                5. Save Data
                6. Load Data
                7. Exit""";

        System.out.println(menu);
        System.out.print("Enter you choice: ");
    }

    public static void printSpacer() {
        System.out.println("======================================================");
    }
}
