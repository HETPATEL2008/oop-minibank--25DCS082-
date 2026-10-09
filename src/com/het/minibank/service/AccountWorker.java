package com.het.minibank.service;

import com.het.minibank.exception.InvalidAmountException;
import com.het.minibank.model.Account;

public class AccountWorker implements Runnable {

    private final Account account;
    private final int times;
    private final long amount;

    public AccountWorker(Account account, int times, long amount) {
        this.account = account;
        this.times = times;
        this.amount = amount;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name + " started");

        for (int i = 0; i < times; i++) {
            try {
                account.deposit(amount);
            } catch (InvalidAmountException e) {
                System.out.println(name + " deposit failed: " + e.getMessage());
            }
        }

        System.out.println(name + " finished");
    }
}
