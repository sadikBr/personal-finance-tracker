package com.brahimsadik.personalFinanceTracker.financialManager;

import com.brahimsadik.personalFinanceTracker.persistenceManager.PersistenceManager;
import com.brahimsadik.personalFinanceTracker.transaction.Transaction;
import com.brahimsadik.personalFinanceTracker.transaction.TransactionType;

import java.io.IOException;
import java.util.ArrayList;

public class FinancialManager {
    private static final ArrayList<Transaction> transactions = PersistenceManager.loadTransactions();

    public static void addTransaction(Transaction transaction) throws IOException {
        FinancialManager.transactions.add(transaction);
        PersistenceManager.saveTransaction(transaction);
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

    public static int getTheNumberOfTransactionsByType(TransactionType type) {
        ArrayList<Transaction> transactions = FinancialManager.getAllTransactionsByType(type);

        return transactions.size();
    }

    public static double getTotalOfType(TransactionType type) {
        ArrayList<Transaction> transactions = FinancialManager.getAllTransactionsByType(type);
        double total = 0;

        for (Transaction transaction : transactions) {
            total += transaction.getAmount();
        }

        return total;
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
