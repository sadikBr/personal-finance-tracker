package com.brahimsadik.personalFinanceTracker;

import com.brahimsadik.personalFinanceTracker.displayManager.DisplayManager;
import com.brahimsadik.personalFinanceTracker.financialManager.FinancialManager;
import com.brahimsadik.personalFinanceTracker.transaction.Transaction;
import com.brahimsadik.personalFinanceTracker.transaction.TransactionType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        DisplayManager.printSpacer();
        DisplayManager.printApplicationName();
        while (choice != 7) {
            DisplayManager.printSpacer();
            DisplayManager.displayMenuOptions();

            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                DisplayManager.printSpacer();
                System.out.println("The choice should not be a non numerical value.");
            } finally {
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                case 2:
                    TransactionType type = choice == 1 ? TransactionType.INCOME : TransactionType.EXPENSE;

                    DisplayManager.printSpacer();
                    DisplayManager.printTransactionCategory();
                    String category = scanner.nextLine();

                    long amount = -1;

                    while (amount < 0) {
                        DisplayManager.printSpacer();
                        DisplayManager.printAmountPrompt();

                        try {
                            amount = scanner.nextLong();
                            if (amount < 0) {
                                DisplayManager.printSpacer();
                                System.out.println("The amount cannot be a negative value.");
                            }
                        } catch (InputMismatchException e) {
                            DisplayManager.printSpacer();
                            System.out.println("Please provide a valid number for the amount.");
                        } finally {
                            scanner.nextLine();
                        }
                    }

                    DisplayManager.printSpacer();
                    DisplayManager.printDescriptionPrompt();
                    String description = scanner.nextLine();

                    Transaction transaction = new Transaction()
                            .setDescription(description)
                            .setAmount(amount)
                            .setType(type)
                            .setCategory(category)
                            .setDate(LocalDate.now());

                    DisplayManager.printSpacer();
                    System.out.println(type +" - "+ category +" - "+ description +" - "+ amount);
                    try {
                        FinancialManager.addTransaction(transaction);
                    } catch (IOException e) {
                        System.out.println("There was problem saving this transaction to the file system.");
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    ArrayList<Transaction> transactions = FinancialManager.getAllTransactions();

                    if (transactions.isEmpty()) {
                        DisplayManager.printSpacer();
                        DisplayManager.printNoTransactionsMessage();
                        break;
                    }

                    for (Transaction trans : transactions) {
                        DisplayManager.printSpacer();
                        DisplayManager.printTransaction(trans);
                    }

                    break;
                case 4:
                    DisplayManager.printSpacer();
                    DisplayManager.printTransactionsSummary();
                    break;
                case 5:
                case 6:
                    DisplayManager.printSpacer();
                    System.out.println("This will be implemented soon.");
                    break;
                case 7:
                    DisplayManager.printSpacer();
                    System.out.println("Everything is saved. See you later!");
                    DisplayManager.printSpacer();
                    break;
                default:
                    DisplayManager.printSpacer();
                    System.out.println("Please enter a valid choice (1-7).");
                    break;
            }
        }

        scanner.close();
    }
}