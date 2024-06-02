package com.example.colossaltitan.service;

import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ExerciseService {


    Page<ExerciseDTO> exercisesList(int page, int size);

    List<ExerciseDTO> searchExercisesByExercise_Name(String exerciseName);

    List<ExerciseDTO> getAllExercises();

    List<ExerciseDTO> findWorkoutsByMuscleGroupLegs();

    List<ExerciseDTO> findWorkoutsByMuscleGroupArms();

    List<ExerciseDTO> findWorkoutsByMuscleGroupChest();

    List<ExerciseDTO> findWorkoutsByMuscleGroupBack();

    List<ExerciseDTO> findWorkoutsByMuscleGroupShoulders();
}
