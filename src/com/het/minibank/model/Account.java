package model;

import java.util.Objects;

public abstract class Account {

    private String ownerName;
    private long balance;
    private boolean active;

    private final String accountNumber;

    private static int accountCounter = 0;

    public Account(String ownerName, long openingBalance) {
        this.ownerName = ownerName;
        this.balance = openingBalance;
        this.accountNumber = generateAccountNumber();
        this.active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    private static String generateAccountNumber() {
        accountCounter++;
        return String.format("AC%04d", accountCounter);
    }

    public void deposit(long amount) {
        balance += amount;
    }

    public boolean withdraw(long amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public abstract double interestRate();

    public abstract boolean canWithdraw(long amount);

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(accountNumber);
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber
                + ", Owner Name: " + ownerName
                + ", Balance: " + balance;
    }
}
