package com.example.colossaltitan.exception;

public class CannotFillTheWalletWithNegativeAmountException extends Throwable {
    public CannotFillTheWalletWithNegativeAmountException(String message) {
        super(message);
    }
}
