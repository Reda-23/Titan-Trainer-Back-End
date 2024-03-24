package com.example.colossaltitan.service;

import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;

import java.util.List;

public interface ExerciseService {



    ExerciseDTO addExercise(ExerciseDTO exerciseDTO);


    void deleteExercise(Long id) throws ExerciseNotFoundException;

    List<ExerciseDTO> exercisesList();

}
