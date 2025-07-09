# Personal Finance Tracker (Command Line & File-Based)

## Project Overview

This document outlines an intermediate-level Java SE project: a Command-Line Personal Finance Tracker. The application will allow users to manage their income and expenses, categorize transactions, view summaries, and persist data to a file.

This project goes beyond basic programming concepts, emphasizing object-oriented design, robust file I/O, date/time handling, and more complex data manipulation using Java's Collections Framework.

**Project Goal:** Create a command-line application that allows users to track their income and expenses, categorize transactions, view summaries, and save/load data from a file.

**Core Concepts Covered (Intermediate Focus):**

*   **Object-Oriented Design:** Multiple interdependent classes (`Transaction`, `Category`, `FinancialManager`).
*   **Encapsulation & Abstraction:** Well-defined methods and hidden implementation details.
*   **Enums:** For transaction types (Income/Expense).
*   **Date & Time API (`java.time`):** Handling dates for transactions.
*   **Collections Framework:** More advanced use of `ArrayList`, `HashMap` (e.g., for categorizing transactions or storing categories).
*   **File I/O (Serialization/Deserialization):** Saving and loading objects to/from text files (CSV or custom format).
*   **Exception Handling:** Robustly handling invalid user input or file operations.
*   **Basic Data Aggregation:** Calculating totals, summaries by category, etc.
*   **User Interface (CLI):** More complex menu navigation and user prompts.

## Kanban Board for "Personal Finance Tracker"

This Kanban board provides a structured way to track progress.

**Board Columns:**

*   **Backlog:** Features/tasks not yet started.
*   **To Do:** Tasks ready to be worked on.
*   **In Progress:** Tasks currently being worked on.
*   **Done:** Completed tasks.

---

### 🚀 Backlog (Future Enhancements)

*   **GUI Implementation:** Migrate to a Swing/JavaFX GUI for a desktop application.
*   **Database Integration:** Switch from file-based storage to a relational database (e.g., SQLite, H2) using JDBC.
*   **Budgeting Feature:** Allow users to set monthly budgets for categories and track against them.
*   **Recurring Transactions:** Add functionality for recurring income/expenses.
*   **Export Data:** Export transaction data to CSV or other formats.
*   **Search/Filter Transactions:** Allow searching by description, date range, amount.
*   **Advanced Reporting:** Generate charts or more detailed financial reports.

---

### 📋 To Do (Tasks Ready for Development)

#### Phase 1: Core Data Structures & Basic Transaction Management

*   **Task 1: Project Setup and `Transaction` Class**
    *   **Description:** Initialize the project and define the `Transaction` object.
    *   **Subtasks:**
        *   Create a new Java project.
        *   Define an `enum TransactionType { INCOME, EXPENSE }`.
        *   Create a `Transaction.java` class with fields:
            *   `String description`
            *   `double amount`
            *   `LocalDate date` (use `java.time.LocalDate`)
            *   `TransactionType type`
            *   `String category` (e.g., "Food", "Salary", "Rent")
        *   Add a constructor, getters, and `toString()` method.

*   **Task 2: `FinancialManager` Class (Core Logic)**
    *   **Description:** Create a central class to manage all financial operations.
    *   **Subtasks:**
        *   Create a `FinancialManager.java` class.
        *   Inside, declare an `ArrayList<Transaction>` to hold all transactions.
        *   Add methods:
            *   `addTransaction(Transaction transaction)`
            *   `getAllTransactions()`: returns the list of transactions.
            *   `getTransactionsByType(TransactionType type)`
            *   `getTotalBalance()`: calculates `totalIncome - totalExpense`.

*   **Task 3: Main Application & Basic Menu**
    *   **Description:** Set up the main application loop and display initial menu options.
    *   **Subtasks:**
        *   In `Main.java`, create instances of `Scanner` and `FinancialManager`.
        *   Implement a `while` loop for the main menu.
        *   Display options: "1. Add Income", "2. Add Expense", "3. View All Transactions", "4. View Summary", "5. Save Data", "6. Load Data", "7. Exit".
        *   Handle user input with a `switch` statement.
        *   Implement the "Exit" option.

*   **Task 4: Implement "Add Income" & "Add Expense"**
    *   **Description:** Allow users to input new financial transactions.
    *   **Subtasks:**
        *   For "Add Income":
            *   Prompt for description, amount.
            *   Prompt for category (allow user to type, or pick from a default list, for now just type).
            *   Set `date` to `LocalDate.now()`.
            *   Create `Transaction` object with `TransactionType.INCOME` and add to `FinancialManager`.
        *   For "Add Expense":
            *   Same as income, but with `TransactionType.EXPENSE`.
        *   Implement basic input validation (e.g., `amount` must be positive, handle `InputMismatchException` for non-numeric input).

#### Phase 2: Viewing & Summarizing Data

*   **Task 5: Implement "View All Transactions"**
    *   **Description:** Display a formatted list of all transactions.
    *   **Subtasks:**
        *   Retrieve all transactions from `FinancialManager`.
        *   Iterate and print each transaction's details (date, type, category, description, amount) clearly.
        *   Handle case where no transactions exist.

*   **Task 6: Implement "View Summary"**
    *   **Description:** Provide financial summaries (total income, total expense, net balance).
    *   **Subtasks:**
        *   Add methods to `FinancialManager`:
            *   `getTotalIncome()`
            *   `getTotalExpense()`
        *   Display these totals along with the `getTotalBalance()`.
        *   *(Stretch Goal)* Add a summary by category: e.g., "Food: -$150", "Salary: +$2000". This might require a `Map<String, Double>` to store category totals.

#### Phase 3: Persistence (File I/O)

*   **Task 7: Implement "Save Data" (CSV Format)**
    *   **Description:** Save all transactions to a plain text file (e.g., CSV).
    *   **Subtasks:**
        *   Add `saveTransactions(String filename)` method to `FinancialManager`.
        *   Use `FileWriter` and `BufferedWriter` to write data.
        *   For each transaction, format it into a CSV line: `date,type,amount,category,description`.
        *   Handle `IOException` with `try-catch-finally` to ensure resources are closed.
        *   Print success/failure message.

*   **Task 8: Implement "Load Data" (CSV Format)**
    *   **Description:** Load transactions from a saved CSV file.
    *   **Subtasks:**
        *   Add `loadTransactions(String filename)` method to `FinancialManager`.
        *   Use `FileReader` and `BufferedReader` to read data line by line.
        *   Parse each line back into `Transaction` objects (split by comma).
        *   Handle potential `NumberFormatException` or `ArrayIndexOutOfBoundsException` during parsing for malformed lines.
        *   Clear existing transactions in `FinancialManager` before loading, or ask user if they want to append/overwrite.
        *   Add loaded transactions to the `ArrayList`.
        *   Handle `FileNotFoundException`.
        *   Print success/failure message.

#### Phase 4: Enhancements & Refinements

*   **Task 9: Implement "Delete Transaction"**
    *   **Description:** Allow users to remove transactions.
    *   **Subtasks:**
        *   Add `deleteTransaction(int index)` method to `FinancialManager`.
        *   Prompt user to view transactions first, then enter the number/index of the transaction to delete.
        *   Implement bounds checking (index exists).
        *   Remove the transaction from the `ArrayList`.

*   **Task 10: Improve User Experience (Input & Validation)**
    *   **Description:** Make the command-line interface more robust and user-friendly.
    *   **Subtasks:**
        *   Refine all input prompts to be clearer.
        *   Add more comprehensive error handling for all user inputs (e.g., non-numeric input for choices, negative amounts, invalid dates if applicable).
        *   Implement loops to re-prompt for valid input until successful.
        *   Clear the console after each operation (can be tricky in pure Java, might involve printing many blank lines).

---

### 🚧 In Progress (Current Focus)

*   *(Move a task here when you start working on it)*

---

### ✅ Done (Completed Tasks)

*   *(Move tasks here once they are fully implemented and tested)*

---

## Development Workflow Recommendations

1.  **Start Small:** Begin with the first task in "To Do" and focus on completing it before moving to the next.
2.  **Test Constantly:** After implementing any feature, run your application and thoroughly test that specific functionality. For instance, after implementing "Add Income," add several income entries, then view them to ensure they appear correctly.
3.  **Code Incrementally:** Avoid writing large chunks of code at once. Implement a small part of a feature, compile, and test it. This makes debugging much easier.
4.  **Refactor Early & Often:** As your codebase grows, you might identify better ways to organize your classes, methods, or handle data. Don't hesitate to refactor, but do so in small, controlled steps.
5.  **Use Version Control (Git/GitHub):**
    *   Initialize a Git repository for your project.
    *   Commit your code frequently, especially after completing a task or a significant subtask.
    *   Use meaningful commit messages.
    *   Push your code to GitHub regularly to back it up and showcase your progress.
6.  **Master Your IDE's Debugger:** The debugger is an invaluable tool for understanding how your code executes, identifying logical errors, and inspecting variable states. Learn how to set breakpoints, step through code, and examine variables.
7.  **Consult Official Documentation:** When you encounter a new class, method, or concept (e.g., `java.time.LocalDate`, `FileWriter`), refer to the official Oracle Java documentation. It's the most authoritative source.
8.  **Leverage Online Communities:** If you get stuck on a problem for an extended period, utilize resources like Stack Overflow. Before asking, ensure you've debugged your code and can clearly articulate the problem and what you've tried.
9.  **Practice Patience & Persistence:** Learning to program is a journey with many challenges. Don't get discouraged by bugs or errors; view them as opportunities to learn and improve your problem-solving skills.

