package net.java.banking;

import java.util.ArrayList;
import java.util.List;

public class BankManager {
    private List<BankAccount> accounts = new ArrayList<>();

    // Create a new bank account
    public void createAccount(String accountNumber, String accountHolder) {
        BankAccount newAccount = new BankAccount(accountNumber, accountHolder);
        accounts.add(newAccount);
        System.out.println("New account created for " + accountHolder + " with Account Number: " + accountNumber);
    }

    // Find an account by account number
    private BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    // Deposit money into an account
    public void depositToAccount(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Withdraw money from an account
    public void withdrawFromAccount(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    // Transfer money between two accounts
    public void transferBetweenAccounts(String fromAccountNumber, String toAccountNumber, double amount) {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(toAccount, amount);
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    // Display details for all accounts
    public void displayAllAccounts() {
        for (BankAccount account : accounts) {
            account.displayAccountDetails();
        }
    }
}
