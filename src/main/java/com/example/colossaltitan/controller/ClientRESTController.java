package com.example.colossaltitan.controller;


import com.example.colossaltitan.dto.ClientDTO;
import com.example.colossaltitan.exception.ClientNotFoundException;
import com.example.colossaltitan.exception.WorkoutNotFoundException;
import com.example.colossaltitan.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "/api/client")
@CrossOrigin("*")
public class ClientRESTController {


    private ClientService clientService;



    @PostMapping("/")
    public ResponseEntity<ClientDTO> addClient(@RequestBody ClientDTO clientDTO){
        ClientDTO savedClient = clientService.addClient(clientDTO);
        return new ResponseEntity<>(savedClient, HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<ClientDTO> getClientById(@PathVariable Long clientId) throws ClientNotFoundException {
        ClientDTO clientDTO = clientService.getClientById(clientId);
        return new ResponseEntity<>(clientDTO,HttpStatus.OK);
    }

    @PutMapping("/update/{clientId}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable Long clientId,@RequestBody ClientDTO clientDTO) throws ClientNotFoundException {
        ClientDTO updatedClient = clientService.updateClient(clientId,clientDTO);
        return new ResponseEntity<>(updatedClient,HttpStatus.OK);
    }

    @GetMapping("/clients")
    public ResponseEntity<List<ClientDTO>> getAllClients(){
        List<ClientDTO> clientDTOS = clientService.clientList();
        return new ResponseEntity<>(clientDTOS,HttpStatus.OK);
    }

    @PostMapping("/setWorkout/{clientId}/{workoutId}")
    public ResponseEntity<?> addWorkoutToClient(@PathVariable Long clientId ,@PathVariable Long workoutId) throws WorkoutNotFoundException, ClientNotFoundException {
        clientService.addWorkoutToClient(clientId, workoutId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
