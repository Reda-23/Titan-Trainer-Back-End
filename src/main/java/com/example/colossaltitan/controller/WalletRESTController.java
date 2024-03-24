package com.example.colossaltitan.controller;


import com.example.colossaltitan.exception.CannotFillTheWalletWithNegativeAmountException;
import com.example.colossaltitan.exception.ClientNotFoundException;
import com.example.colossaltitan.service.WalletService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/wallet")
public class WalletRESTController {


    private WalletService walletService;


    @PostMapping("/fill/{clientId}")
    public ResponseEntity<?> fillClientWallet(@PathVariable Long clientId, @RequestParam int amount) throws ClientNotFoundException, CannotFillTheWalletWithNegativeAmountException {
        walletService.fillWallet(clientId,amount);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
