package com.example.colossaltitan.service;

import com.example.colossaltitan.dto.GroupTrainingDTO;
import com.example.colossaltitan.exception.ClientHasAlreadyBookedThisGroupTrainingException;

import java.util.List;


public interface GroupTrainingService {


    GroupTrainingDTO addGroupTraining(GroupTrainingDTO groupTrainingDTO);
    List<GroupTrainingDTO> groupTrainingList();

    void bookGroupTraining(Long clientId,Long groupTrainingId) throws ClientHasAlreadyBookedThisGroupTrainingException;

}
