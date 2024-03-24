package com.example.colossaltitan.controller;


import com.example.colossaltitan.dto.WorkoutDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;
import com.example.colossaltitan.exception.WorkoutListIsEmptyException;
import com.example.colossaltitan.exception.WorkoutNotFoundException;
import com.example.colossaltitan.service.WorkoutService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping( "/api/workout")
@AllArgsConstructor
public class WorkoutRESTController {

    private WorkoutService workoutService;


    @PostMapping("/")
    public ResponseEntity<WorkoutDTO> addWorkout(@RequestBody WorkoutDTO workoutDTO){
        WorkoutDTO savedWorkout = workoutService.addWorkout(workoutDTO);
        return new ResponseEntity<>(savedWorkout, HttpStatus.OK);
    }

    @DeleteMapping("/{workoutId}")
    public ResponseEntity<?> deleteWorkout(@PathVariable Long workoutId) throws WorkoutNotFoundException {
        workoutService.deleteWorkout(workoutId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addExercise/{exerciseId}/{workoutId}")
    public ResponseEntity<?> addExerciseToWorkout(@PathVariable Long exerciseId,@PathVariable Long workoutId) throws WorkoutNotFoundException, ExerciseNotFoundException {
        workoutService.addExerciseToWorkout(exerciseId, workoutId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/workouts")
    public ResponseEntity<List<WorkoutDTO>> workoutList() throws WorkoutListIsEmptyException {
        List<WorkoutDTO> workoutList = workoutService.workoutList();
        return new ResponseEntity<>(workoutList,HttpStatus.OK);
    }
}
