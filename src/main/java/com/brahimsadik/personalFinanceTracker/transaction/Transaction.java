package com.brahimsadik.personalFinanceTracker.transaction;

import java.time.LocalDate;
import java.util.UUID;

public class Transaction {
    private
        final String id;
        String description;
        double amount;
        LocalDate date;
        TransactionType type;
        String category; // (e.g., "Food", "Salary", "Rent")

    public Transaction() {
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return this.description;
    }

    public double getAmount() {
        return this.amount;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public TransactionType getType() {
        return this.type;
    }

    public String getCategory() {
        return this.category;
    }

    public Transaction setDescription(String desc) {
        this.description = desc;
        return this;
    }

    public Transaction setAmount(double amt) {
        this.amount = amt;
        return this;
    }

    public Transaction setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public Transaction setType(TransactionType type) {
        this.type = type;
        return this;
    }

    public Transaction setCategory(String cat) {
        this.category = cat;
        return this;
    }

    @Override
    public String toString() {
        return "Transaction ID: " + this.id;
    }
}
