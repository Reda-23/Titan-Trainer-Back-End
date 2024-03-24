package com.example.colossaltitan.service;

import com.example.colossaltitan.dto.ClientDTO;
import com.example.colossaltitan.exception.CannotFillTheWalletWithNegativeAmountException;
import com.example.colossaltitan.exception.ClientNotFoundException;
import com.example.colossaltitan.exception.WorkoutNotFoundException;


import java.util.List;

public interface ClientService {




    ClientDTO addClient(ClientDTO clientDTO);

    ClientDTO getClientById(Long clientId) throws ClientNotFoundException;

    ClientDTO updateClient(Long id , ClientDTO clientDTO) throws ClientNotFoundException;
    List<ClientDTO> clientList();

    void addWorkoutToClient(Long clientID, Long workoutID) throws ClientNotFoundException, WorkoutNotFoundException;
}
