package com.brahimsadik.personalFinanceTracker.persistenceManager;

import com.brahimsadik.personalFinanceTracker.transaction.Transaction;

import java.util.ArrayList;

public class PersistenceManager {
    private static final String savePath = "~/transactions.csv";

    public static ArrayList<Transaction> loadTransactions() {
        return new ArrayList<>();
    }

    public static void saveTransaction(Transaction transaction) {
        System.out.println("Saving the transaction with id " + transaction.getId() + " to " + PersistenceManager.getPath());
    }

    public static String getPath() {
       return PersistenceManager.savePath;
    }
}
