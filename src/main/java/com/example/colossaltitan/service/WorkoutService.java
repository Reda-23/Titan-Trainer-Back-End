package com.example.colossaltitan.service;

import com.example.colossaltitan.dto.WorkoutDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;
import com.example.colossaltitan.exception.WorkoutListIsEmptyException;
import com.example.colossaltitan.exception.WorkoutNotFoundException;

import java.util.List;

public interface WorkoutService {

    WorkoutDTO addWorkout(WorkoutDTO workoutDTO);
    void deleteWorkout(Long workoutId) throws WorkoutNotFoundException;

    void addExerciseToWorkout(Long exerciseID, Long workoutID) throws ExerciseNotFoundException, WorkoutNotFoundException;

    List<WorkoutDTO> workoutList() throws WorkoutListIsEmptyException;
}
