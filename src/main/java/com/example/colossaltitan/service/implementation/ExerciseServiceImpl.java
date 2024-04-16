package com.example.colossaltitan.service.implementation;

import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.mapper.ModelMapper;
import com.example.colossaltitan.model.Exercise;
import com.example.colossaltitan.repository.ExerciseRepository;
import com.example.colossaltitan.service.ExerciseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;
    private ModelMapper mapper;




    @Override
    public List<ExerciseDTO> exercisesList() {
        List<Exercise> exercises = exerciseRepository.findAll();
        log.info("fetching the exercises list from the repository ");
        return exercises.stream().map(ex -> mapper.fromExerciseToDTO(ex)).toList();
    }

    @Override
    public List<ExerciseDTO> searchExercisesByExercise_Name(String exerciseName){
        List<Exercise> exercises = exerciseRepository.searchExercisesByName(exerciseName);
        List<ExerciseDTO> exerciseDTOS = exercises.stream().map(ex -> mapper.fromExerciseToDTO(ex)).collect(Collectors.toList());
        return exerciseDTOS;
    }

}
