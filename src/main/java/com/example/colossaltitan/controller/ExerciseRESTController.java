package com.example.colossaltitan.controller;


import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;
import com.example.colossaltitan.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "/api/exercise")
public class ExerciseRESTController {

    private ExerciseService exerciseService;


    @PostMapping("/")
    public ResponseEntity<ExerciseDTO> addExercise(@RequestBody ExerciseDTO exerciseDTO){
        ExerciseDTO savedExercise = exerciseService.addExercise(exerciseDTO);
        return new ResponseEntity<>(savedExercise, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{exerciseId}")
    public ResponseEntity<?> deleteExercise(@PathVariable Long exerciseId) throws ExerciseNotFoundException {
        exerciseService.deleteExercise(exerciseId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/exercises")
    public ResponseEntity<List<ExerciseDTO>> exercisesList(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.exercisesList();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }
}
