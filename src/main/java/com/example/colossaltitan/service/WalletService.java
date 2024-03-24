package com.example.colossaltitan.service;

import com.example.colossaltitan.exception.CannotFillTheWalletWithNegativeAmountException;
import com.example.colossaltitan.exception.ClientNotFoundException;

public interface WalletService {


    void fillWallet(Long clientId , double amount) throws ClientNotFoundException, CannotFillTheWalletWithNegativeAmountException;

}
