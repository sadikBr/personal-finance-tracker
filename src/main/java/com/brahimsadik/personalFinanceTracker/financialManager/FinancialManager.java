package com.brahimsadik.personalFinanceTracker.financialManager;

import com.brahimsadik.personalFinanceTracker.transaction.Transaction;
import com.brahimsadik.personalFinanceTracker.transaction.TransactionType;

import java.util.ArrayList;

public class FinancialManager {
    private static final ArrayList<Transaction> transactions = new ArrayList<>();

    public static void addTransaction(Transaction transaction) {
        FinancialManager.transactions.add(transaction);
        System.out.println("Transaction with id " + transaction.getId() + " has been saved in memory.");
    }

    public static ArrayList<Transaction> getAllTransactions() {
        return FinancialManager.transactions;
    }

    public static ArrayList<Transaction> getAllTransactionsByType(TransactionType type) {
        ArrayList<Transaction> transactionsByType = new ArrayList<>();

        for (Transaction transaction : FinancialManager.transactions) {
            if (transaction.getType() == type) {
                transactionsByType.add(transaction);
            }
        }

        return transactionsByType;
    }

    public static double getTotalBalance() {
        double totalExpenses = 0;
        double totalIncome = 0;

        for (Transaction transaction: FinancialManager.transactions) {
            if (transaction.getType() == TransactionType.EXPENSE) {
                totalExpenses += transaction.getAmount();
            } else {
                totalIncome += transaction.getAmount();
            }
        }

        return totalIncome - totalExpenses;
    }

}
