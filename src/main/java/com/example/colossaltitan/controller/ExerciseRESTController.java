package com.example.colossaltitan.controller;


import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.service.ExerciseService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping( "/api/exercise")
@CrossOrigin("*")
public class ExerciseRESTController {

    private ExerciseService exerciseService;




    @GetMapping("/exercises")
    public ResponseEntity<Page<ExerciseDTO>> exercisesList(@RequestParam(defaultValue = "0") int page ,@RequestParam(defaultValue = "10") int size){
        Page<ExerciseDTO> exerciseDTOS = exerciseService.exercisesList(page, size);
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ExerciseDTO>> searchExercisesByName(@RequestParam String exerciseName){
        List<ExerciseDTO> exerciseDTOS = exerciseService.searchExercisesByExercise_Name(exerciseName);
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);

    }

    @GetMapping("/all")
    @PreAuthorize("hasAuthority('SCOPE_USER')")
    public ResponseEntity<List<ExerciseDTO>> allExercises(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.getAllExercises();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }


    @GetMapping("/all/legs")
    public ResponseEntity<List<ExerciseDTO>> allLegExercises(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.findWorkoutsByMuscleGroupLegs();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }


    @GetMapping("/all/chest")
    public ResponseEntity<List<ExerciseDTO>> allChestExercises(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.findWorkoutsByMuscleGroupChest();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }

    @GetMapping("/all/arms")
    public ResponseEntity<List<ExerciseDTO>> allArmsExercises(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.findWorkoutsByMuscleGroupArms();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }

    @GetMapping("/all/back")
    public ResponseEntity<List<ExerciseDTO>> allBackExercises(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.findWorkoutsByMuscleGroupBack();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }

    @GetMapping("/all/shoulders")
    public ResponseEntity<List<ExerciseDTO>> allShouldersExercises(){
        List<ExerciseDTO> exerciseDTOS = exerciseService.findWorkoutsByMuscleGroupShoulders();
        return new ResponseEntity<>(exerciseDTOS,HttpStatus.OK);
    }


}
