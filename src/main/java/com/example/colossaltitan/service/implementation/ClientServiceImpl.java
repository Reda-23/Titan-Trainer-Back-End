package com.example.colossaltitan.service.implementation;

import com.example.colossaltitan.dto.ClientDTO;
import com.example.colossaltitan.exception.ClientNotFoundException;
import com.example.colossaltitan.exception.WorkoutNotFoundException;
import com.example.colossaltitan.mapper.ModelMapper;
import com.example.colossaltitan.model.Client;
import com.example.colossaltitan.model.Workout;
import com.example.colossaltitan.repository.ClientRepository;
import com.example.colossaltitan.repository.WorkoutRepository;
import com.example.colossaltitan.service.ClientService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
@Transactional
@Slf4j
public class ClientServiceImpl implements ClientService {

    private ModelMapper mapper;
    private ClientRepository clientRepository;

    private WorkoutRepository workoutRepository;



    @Override
    public ClientDTO addClient(ClientDTO clientDTO) {
        Client client = mapper.fromDTOToClient(clientDTO);
        Client savedClient = clientRepository.save(client);
        log.info("client saved into the db {} ",savedClient.getClientName());
        return mapper.fromClientToDTO(savedClient);
    }

    @Override
    public ClientDTO getClientById(Long clientId) throws ClientNotFoundException {
        Client client = clientRepository.getClientByClientId(clientId)
                .orElseThrow(()-> new ClientNotFoundException("client is not found with this id " + clientId));
        log.info("fetching client from the db with the id {}",clientId);
        return mapper.fromClientToDTO(client);
    }

    @Override
    public ClientDTO updateClient(Long clientId , ClientDTO clientDTO) throws ClientNotFoundException {
        Client client = clientRepository.getClientByClientId(clientId)
                .orElseThrow(()-> new ClientNotFoundException("client is not found with this id " + clientId));
        client.setClientName(clientDTO.getClientName());
        client.setClientEmail(clientDTO.getClientEmail());
        client.setPassword(clientDTO.getPassword());
        client.setPhoneNumber(clientDTO.getPhoneNumber());
        client.setGender(clientDTO.getGender());
        client.setCity(clientDTO.getCity());
        client.setAddress(clientDTO.getAddress());
        client.setLanguage(clientDTO.getLanguage());
        client.setHeight(clientDTO.getHeight());
        client.setWeight(clientDTO.getWeight());
        Client updatedClient = clientRepository.save(client);
        log.trace("client updated successfully {} ",updatedClient.getClientName());
        return mapper.fromClientToDTO(updatedClient);
    }

    @Override
    public List<ClientDTO> clientList() {
        List<Client> clientList = clientRepository.findAll();
        log.trace("fetching the client list from the repository ");
        return clientList.stream().map(c -> mapper.fromClientToDTO(c)).toList();
    }

    @Override
    public void addWorkoutToClient(Long clientID, Long workoutID) throws ClientNotFoundException, WorkoutNotFoundException {
        Client client = clientRepository.getClientByClientId(clientID).orElseThrow(()->new  ClientNotFoundException("client is not found"));
        Workout workout = workoutRepository.findWorkoutByWorkoutId(workoutID)
                .orElseThrow(()-> new WorkoutNotFoundException("workout is not found with this id : "+ workoutID));
        client.getWorkouts().add(workout);
        log.trace("workout added to the client {}",client.getClientName());
        clientRepository.save(client);
    }




}
