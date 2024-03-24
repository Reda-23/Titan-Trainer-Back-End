package com.example.colossaltitan.service.implementation;

import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;
import com.example.colossaltitan.mapper.ModelMapper;
import com.example.colossaltitan.model.Exercise;
import com.example.colossaltitan.repository.ExerciseRepository;
import com.example.colossaltitan.service.ExerciseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;
    private ModelMapper mapper;

    @Override
    public ExerciseDTO addExercise(ExerciseDTO exerciseDTO) {
        Exercise exercise = mapper.fromDTOToExercise(exerciseDTO);
        Exercise savedExercise = exerciseRepository.save(exercise);
        log.info("exercise saved to the db {} ", savedExercise.getExoName());
        return mapper.fromExerciseToDTO(savedExercise);
    }

    @Override
    public void deleteExercise(Long id) throws ExerciseNotFoundException {
        Exercise exercise = exerciseRepository.findExerciseByExerciseId(id)
                .orElseThrow(()-> new ExerciseNotFoundException("exercise not found") );
        log.info("exercise deleted from the db {}",exercise.getExoName());
        exerciseRepository.delete(exercise);
    }

    @Override
    public List<ExerciseDTO> exercisesList() {
        List<Exercise> exercises = exerciseRepository.findAll();
        log.info("fetching the exercises list from the repository ");
        return exercises.stream().map(ex -> mapper.fromExerciseToDTO(ex)).toList();
    }

}
