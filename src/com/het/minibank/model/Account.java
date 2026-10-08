package com.het.minibank.model;

import com.het.minibank.exception.AccountNotFoundException;
import com.het.minibank.exception.BankException;
import com.het.minibank.exception.InsufficientFundsException;
import com.het.minibank.exception.InvalidAmountException;
import com.het.minibank.model.annotation.Id;
import com.het.minibank.model.annotation.Positive;

import java.util.Objects;

public abstract class Account implements Transactable, InterestBearing {

    private String ownerName;

    @Positive
    private long balance;
    private boolean active;

    private final String accountNumber;

    @Id
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

    public void deposit(long amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero: " + amount);
        }
        balance += amount;
    }

    public boolean withdraw(long amount) throws InvalidAmountException, InsufficientFundsException {
        if (amount <= 0) {
            throw new InvalidAmountException("Amount must be greater than zero: " + amount);
        }
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        return true;
    }

    public void transfer(Account to, long amount) throws BankException {
        if (to == null) {
            throw new AccountNotFoundException("Destination account not found");
        }
        try {
            withdraw(amount);
            to.deposit(amount);
            System.out.println("Transferred " + amount + " from "
                    + accountNumber + " to " + to.accountNumber);
        } catch (BankException e) {
            System.out.println("[LOG] Transfer failed: " + e.getMessage());
            throw e;   // re-throw so the caller decides what to do
        } finally {
            System.out.println("Transfer attempt on " + accountNumber + " completed.");
        }
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
