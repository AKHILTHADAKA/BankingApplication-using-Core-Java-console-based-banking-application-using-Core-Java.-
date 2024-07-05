package net.java.banking;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // BankAccount class Constructor 
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = 0.0; 
    }

    // Deposit money into the account
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount deposited successfully. Current Balance: " + balance);
        } else {
            System.out.println("Invalid amount. Please enter a positive number.");
        }
    }

    // Withdraw money from the account
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive number.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn successfully. Remaining Balance: " + balance);
        }
    }

    // Transfer money to another bank account
    public void transfer(BankAccount otherAccount, double amount) {
        if (amount <= balance) {
            this.withdraw(amount); 
            otherAccount.deposit(amount);
            System.out.println("Transfer successful. New Balance: " + this.balance);
        } else {
            System.out.println("Insufficient balance. Transfer failed.");
        }
    }

    // Display account details
    public void displayAccountDetails() {
        System.out.println("Account Number: " + accountNumber + ", Account Holder: " + accountHolder + ", Balance: " + balance);
    }

    // Getters and Setters
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public void setAccountHolder(String accountHolder) { this.accountHolder = accountHolder; }
    public double getBalance() { return balance; }

}