package com.brahimsadik.personalFinanceTracker;

import com.brahimsadik.personalFinanceTracker.financialManager.FinancialManager;
import com.brahimsadik.personalFinanceTracker.transaction.Transaction;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("==================== Personal Finance Tracker =====================");

        for (int i = 0; i < 10; i++) {
            Transaction trans = new Transaction();

            FinancialManager.addTransaction(trans);

            System.out.println(trans.toString());
        }
    }
}