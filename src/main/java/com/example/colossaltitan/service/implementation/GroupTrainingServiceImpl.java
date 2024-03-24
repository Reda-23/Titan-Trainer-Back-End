package com.example.colossaltitan.service.implementation;

import com.example.colossaltitan.dto.GroupTrainingDTO;
import com.example.colossaltitan.exception.ClientHasAlreadyBookedThisGroupTrainingException;
import com.example.colossaltitan.mapper.ModelMapper;
import com.example.colossaltitan.model.Client;
import com.example.colossaltitan.model.GroupTraining;
import com.example.colossaltitan.repository.ClientRepository;
import com.example.colossaltitan.repository.GroupTrainingRepository;
import com.example.colossaltitan.service.ClientService;
import com.example.colossaltitan.service.GroupTrainingService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
@Transactional
public class GroupTrainingServiceImpl implements GroupTrainingService {

    private GroupTrainingRepository groupTrainingRepository;
    private ClientRepository  clientRepository;
    private ModelMapper mapper;



    @Override
    public GroupTrainingDTO addGroupTraining(GroupTrainingDTO groupTrainingDTO) {
        GroupTraining groupTraining = mapper.fromDTOToGroupTraining(groupTrainingDTO);
        groupTraining.setNumberOfPlacesLeft(groupTrainingDTO.getNumberOfPlaces());
        GroupTraining savedGroupTraining = groupTrainingRepository.save(groupTraining);
        return mapper.fromGroupTrainingToDTO(savedGroupTraining);
    }

    @Override
    public List<GroupTrainingDTO> groupTrainingList() {
        List<GroupTraining> groupTrainings = groupTrainingRepository.findAll();
        List<GroupTrainingDTO> groupTrainingDTOS = groupTrainings.stream()
                .map(gt -> mapper.fromGroupTrainingToDTO(gt)).toList();
        return groupTrainingDTOS;
    }

    @Override
    public void bookGroupTraining(Long clientId, Long groupTrainingId) throws ClientHasAlreadyBookedThisGroupTrainingException {
        Client client = clientRepository.getClientByClientId(clientId).get();
        GroupTraining groupTraining = groupTrainingRepository.findById(groupTrainingId).get();
        boolean bookingCheck = clientHasBooked(groupTraining.getClients(),client);
        if (bookingCheck == true) throw new ClientHasAlreadyBookedThisGroupTrainingException("client already exist in this group training");
        groupTraining.getClients().add(client);

        groupTraining.setNumberOfPlacesLeft(groupTraining.getNumberOfPlaces() - groupTraining.getClients().size());
        groupTrainingRepository.save(groupTraining);

    }






    public static boolean clientHasBooked(List<Client> clients,Client client){
        return clients.contains(client);
    }
}
