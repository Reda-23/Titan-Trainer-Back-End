package com.example.colossaltitan.service.implementation;

import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.mapper.ModelMapper;
import com.example.colossaltitan.model.Exercise;
import com.example.colossaltitan.repository.ExerciseRepository;
import com.example.colossaltitan.service.ExerciseService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<ExerciseDTO> exercisesList(int page, int size) {
        Page<Exercise> exercises = exerciseRepository.findAll(PageRequest.of(page - 1, size));
        log.info("fetching the exercises for page {} and size {} ", page, size);
        Page<ExerciseDTO> exerciseList = exercises.map(exo -> mapper.fromExerciseToDTO(exo));
        return exerciseList;
    }

    @Override
    public List<ExerciseDTO> searchExercisesByExercise_Name(String exerciseName){
        List<Exercise> exercises = exerciseRepository.searchExercisesByName(exerciseName);
        List<ExerciseDTO> exerciseDTOS = exercises.stream().map(ex -> mapper.fromExerciseToDTO(ex)).collect(Collectors.toList());
        return exerciseDTOS;
    }

    @Override
    public List<ExerciseDTO> getAllExercises(){
        List<Exercise> exercises = exerciseRepository.findAll();
        List<ExerciseDTO> exerciseDTOS = exercises.stream().map(exo -> mapper.fromExerciseToDTO(exo)).toList();
        return exerciseDTOS;
    }


    @Override
    public List<ExerciseDTO> findWorkoutsByMuscleGroupLegs(){
        List<Exercise> exercises = exerciseRepository.findWorkoutsByMuscleGroupLegs();
        return exercises.stream().map(e -> mapper.fromExerciseToDTO(e)).toList();
    }

    @Override
    public List<ExerciseDTO> findWorkoutsByMuscleGroupArms(){
        List<Exercise> exercises = exerciseRepository.findWorkoutsByMuscleGroupArms();
        return exercises.stream().map(e -> mapper.fromExerciseToDTO(e)).toList();
    }

    @Override
    public List<ExerciseDTO> findWorkoutsByMuscleGroupChest(){
        List<Exercise> exercises = exerciseRepository.findWorkoutsByMuscleGroupChest();
        return exercises.stream().map(e -> mapper.fromExerciseToDTO(e)).toList();
    }

    @Override
    public List<ExerciseDTO> findWorkoutsByMuscleGroupBack(){
        List<Exercise> exercises = exerciseRepository.findWorkoutsByMuscleGroupBack();
        return exercises.stream().map(e -> mapper.fromExerciseToDTO(e)).toList();
    }

    @Override
    public List<ExerciseDTO> findWorkoutsByMuscleGroupShoulders(){
        List<Exercise> exercises = exerciseRepository.findWorkoutsByMuscleGroupShoulders();
        return exercises.stream().map(e -> mapper.fromExerciseToDTO(e)).toList();
    }

}
