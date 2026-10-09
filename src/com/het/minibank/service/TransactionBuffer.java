package com.het.minibank.service;

import com.het.minibank.model.Command;

public class TransactionBuffer {

    private final Command[] items;
    private final Object lock = new Object();
    private int head = 0;
    private int tail = 0;
    private int count = 0;

    public TransactionBuffer(int capacity) {
        items = new Command[capacity];
    }

    // producer calls this
    public void put(Command command) throws InterruptedException {
        synchronized (lock) {
            while (count == items.length) {
                lock.wait();              // buffer full: wait for the consumer
            }
            items[tail] = command;
            tail = (tail + 1) % items.length;
            count++;
            lock.notifyAll();             // wake the consumer
        }
    }

    // consumer calls this
    public Command take() throws InterruptedException {
        synchronized (lock) {
            while (count == 0) {
                lock.wait();              // buffer empty: wait for the producer
            }
            Command command = items[head];
            items[head] = null;
            head = (head + 1) % items.length;
            count--;
            lock.notifyAll();             // wake the producer
            return command;
        }
    }
}
