package com.brahimsadik.personalFinanceTracker.displayManager;

import com.brahimsadik.personalFinanceTracker.financialManager.FinancialManager;
import com.brahimsadik.personalFinanceTracker.transaction.Transaction;
import com.brahimsadik.personalFinanceTracker.transaction.TransactionType;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;

public class DisplayManager {

    public static void printApplicationName() {
        System.out.println("=================== Personal Finance Tracker ===================");
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
        System.out.println("================================================================");
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

    public static void printTransaction(Transaction transaction) {
        System.out.printf("""
                Transaction ID: %s
                Transaction Description: %s
                A %s %s transaction with amount %.2f (MAD) processed on %s""", transaction.getId(), transaction.getDescription(), transaction.getCategory(), transaction.getType(), transaction.getAmount(), transaction.getDate());
        System.out.println();
    }

    public static void printNoTransactionsMessage() {
        System.out.println("You don't have any transactions yet. Create one to get Started.");
    }

    public static void printTransactionsSummary() {
        ArrayList<Transaction> transactions = FinancialManager.getAllTransactions();

        if (transactions.isEmpty()) {
            DisplayManager.printNoTransactionsMessage();
            return;
        }

        int incomeTransactionsNumber = FinancialManager.getTheNumberOfTransactionsByType(TransactionType.INCOME);
        double totalIncome = FinancialManager.getTotalOfType(TransactionType.INCOME);

        int expenseTransactionsNumber = FinancialManager.getTheNumberOfTransactionsByType(TransactionType.EXPENSE);
        double totalExpense = FinancialManager.getTotalOfType(TransactionType.EXPENSE);

        System.out.printf("""
                - You have %d INCOME transactions with a total of %.2f (MAD)
                - You have %d EXPENSE transactions with a total of %.2f (MAD)
                - Your total balance is: %.2f (MAD)""", incomeTransactionsNumber, totalIncome, expenseTransactionsNumber, totalExpense, FinancialManager.getTotalBalance());
        System.out.println();
    }
}
