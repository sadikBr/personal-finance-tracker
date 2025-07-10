package com.brahimsadik.personalFinanceTracker.persistenceManager;

import com.brahimsadik.personalFinanceTracker.transaction.Transaction;
import com.brahimsadik.personalFinanceTracker.transaction.TransactionType;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class PersistenceManager {
    private static final String savePath = "/home/bsadik/transactions.csv";

    public static ArrayList<Transaction> loadTransactions() {
        ArrayList<Transaction> transactions = new ArrayList<>();

        File file = new File(PersistenceManager.getPath());
        if (!file.exists()) {
            try {
                boolean fileCreated = file.createNewFile();

                if (!fileCreated) {
                    System.out.println("Unable to create the save file");
                    return transactions;
                }
            } catch (IOException e) {
                System.out.println("Error while creating the save file");
                return transactions;
            }
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PersistenceManager.getPath()))) {

            Stream<String> fileLines = bufferedReader.lines();
            List<String> linesList = fileLines.toList();

            for (int i = 1; i < linesList.size(); i++) {
                String line = linesList.get(i);
                Transaction transaction = PersistenceManager.parseTransaction(line);
                transactions.add(transaction);
            }

            bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Something went wrong while reading the save file. Please try again later.");
            return transactions;
        }

        return transactions;
    }

    public static void saveTransaction(Transaction transaction) throws IOException {
        File file = new File(PersistenceManager.getPath());
        boolean fileCreated = false;
        if (!file.exists()) {
            fileCreated = file.createNewFile();

            if (!fileCreated) {
                System.out.println("The file does not exist and could not create it.");
                return;
            }
        }

        FileWriter fileWriter = new FileWriter(PersistenceManager.getPath(), true);
        BufferedWriter bufferedWriter = PersistenceManager.getBufferedWriter(transaction, fileWriter, fileCreated);

        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Saved the transaction with id " + transaction.getId() + " to " + PersistenceManager.getPath());
    }

    private static BufferedWriter getBufferedWriter(Transaction transaction, FileWriter fileWriter, boolean fileCreated) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        if (fileCreated) {
            bufferedWriter.write("ID, Type, Category, Description, Amount, Created At");
            bufferedWriter.newLine();
        }

        bufferedWriter.write(
                transaction.getId() + ", " +
                transaction.getType().toString() + ", " +
                transaction.getCategory() + ", " +
                transaction.getDescription() + ", " +
                String.valueOf(transaction.getAmount()) + ", " +
                String.valueOf(transaction.getDate())
        );
        bufferedWriter.newLine();

        return bufferedWriter;
    }

    private static Transaction parseTransaction(String csvLine) {
        String[] parts = csvLine.split(", ");
        Transaction transaction = new Transaction(parts[0]);

        transaction.setType(parts[1].equals("INCOME") ? TransactionType.INCOME : TransactionType.EXPENSE);
        transaction.setCategory(parts[2]);
        transaction.setDescription(parts[3]);
        transaction.setAmount(Double.parseDouble(parts[4]));
        transaction.setDate(LocalDate.parse(parts[5]));

        return transaction;
    }

    public static String getPath() {
       return PersistenceManager.savePath;
    }
}
