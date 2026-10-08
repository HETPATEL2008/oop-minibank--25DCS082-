package com.het.minibank.exception;

public class InvalidAmountException extends BankException {

    public InvalidAmountException(String message) {
        super(message);
    }
}