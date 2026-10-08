package com.het.minibank.model;

import com.het.minibank.exception.InsufficientFundsException;
import com.het.minibank.exception.InvalidAmountException;

public interface Transactable {

    void deposit(long amount) throws InvalidAmountException;

    boolean withdraw(long amount) throws InsufficientFundsException, InvalidAmountException;
}
