package com.het.minibank.service;

import com.het.minibank.exception.BankException;
import com.het.minibank.model.Account;
import com.het.minibank.model.TransactionType;

public class TransactionTask implements Runnable {

    private final Account account;
    private final TransactionType type;
    private final long amount;

    public TransactionTask(Account account, TransactionType type, long amount) {
        this.account = account;
        this.type = type;
        this.amount = amount;
    }

    @Override
    public void run() {
        try {
            switch (type) {
                case DEPOSIT -> account.deposit(amount);
                case WITHDRAW -> account.withdraw(amount);
                default -> System.out.println("Unsupported type for a single-account task: " + type);
            }
        } catch (BankException e) {
            System.out.println(Thread.currentThread().getName() + " failed: " + e.getMessage());
        }
    }
}
