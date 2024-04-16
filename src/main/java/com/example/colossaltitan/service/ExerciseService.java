package com.example.colossaltitan.service;

import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;

import java.util.List;

public interface ExerciseService {



    List<ExerciseDTO> exercisesList();

    List<ExerciseDTO> searchExercisesByExercise_Name(String exerciseName);
}
