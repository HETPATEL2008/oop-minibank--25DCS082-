package com.het.minibank.model;

public record Command(TransactionType type, String accountNumber, long amount) {
}
