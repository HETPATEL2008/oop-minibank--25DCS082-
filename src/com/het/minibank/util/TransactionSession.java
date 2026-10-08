package com.het.minibank.util;

public class TransactionSession implements AutoCloseable {

    private final String name;

    public TransactionSession(String name) {
        this.name = name;
        System.out.println(name + " opened");
    }

    @Override
    public void close() {
        System.out.println(name + " closed");
    }
}
