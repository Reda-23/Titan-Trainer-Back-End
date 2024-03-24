package com.example.colossaltitan.service.implementation;

import com.example.colossaltitan.exception.CannotFillTheWalletWithNegativeAmountException;
import com.example.colossaltitan.exception.ClientNotFoundException;
import com.example.colossaltitan.model.Client;
import com.example.colossaltitan.repository.ClientRepository;
import com.example.colossaltitan.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WalletServiceImpl implements WalletService {
    private ClientRepository clientRepository;
    @Override
    public void fillWallet(Long clientId, double amount) throws ClientNotFoundException, CannotFillTheWalletWithNegativeAmountException {
        Client client = clientRepository.getClientByClientId(clientId)
                .orElseThrow(()-> new ClientNotFoundException("client is not found with this id " + clientId));
        if (amount < 0) throw new CannotFillTheWalletWithNegativeAmountException("please fill in the wallet with a positive amount");
        client.setWalletBalance(client.getWalletBalance()+amount);
        clientRepository.save(client);
    }
}
