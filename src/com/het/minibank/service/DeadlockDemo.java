package com.het.minibank.service;

import com.het.minibank.exception.BankException;
import com.het.minibank.model.Account;

public class DeadlockDemo {

    // BUG ON PURPOSE: always locks 'from' first, then 'to'.
    // A->B and B->A therefore lock in opposite order.
    public static void transferUnsafe(Account from, Account to, long amount) {
        synchronized (from) {
            pause();
            synchronized (to) {
                move(from, to, amount);
            }
        }
    }

    // FIX: always lock the account with the smaller accountNumber first
    public static void transferSafe(Account from, Account to, long amount) {
        Account first = from.getAccountNumber().compareTo(to.getAccountNumber()) < 0 ? from : to;
        Account second = (first == from) ? to : from;

        synchronized (first) {
            pause();
            synchronized (second) {
                move(from, to, amount);
            }
        }
    }

    private static void move(Account from, Account to, long amount) {
        try {
            from.withdraw(amount);
            to.deposit(amount);
        } catch (BankException e) {
            System.out.println("Transfer failed: " + e.getMessage());
        }
    }

    // gives the other thread time to grab its first lock, so the deadlock is reliable
    private static void pause() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
