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




    @GetMapping("/exercises")
    public ResponseEntity<List<ExerciseDTO>> exercisesList(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.exercisesList();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ExerciseDTO>> searchExercisesByName(@RequestParam String exerciseName){
        List<ExerciseDTO> exerciseDTOS = exerciseService.searchExercisesByExercise_Name(exerciseName);
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);

    }
}
