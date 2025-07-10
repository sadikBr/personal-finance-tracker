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

    public static void printDescriptionPrompt() {
        System.out.println("Please Enter the description");
        System.out.print("Description: ");
    }

    public static void printAmountPrompt() {
        System.out.println("Please Enter the transaction amount");
        System.out.print("Amount: ");
    }

    public static void printTransactionCategory() {
        System.out.println("Please enter the category of this transaction");
        System.out.print("Category (e.g. Food, Salary, Rent...): ");
    }

    public static void printTransactionTypePrompt() {
        System.out.println("Please choose the type of the transaction");
        System.out.println("1. Income");
        System.out.println("2. Expense");
        System.out.print("Transaction Type: ");
    }
}
