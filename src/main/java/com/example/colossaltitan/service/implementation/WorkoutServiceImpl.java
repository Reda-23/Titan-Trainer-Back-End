package com.example.colossaltitan.service.implementation;

import com.example.colossaltitan.dto.WorkoutDTO;
import com.example.colossaltitan.exception.ExerciseNotFoundException;
import com.example.colossaltitan.exception.WorkoutListIsEmptyException;
import com.example.colossaltitan.exception.WorkoutNotFoundException;
import com.example.colossaltitan.mapper.ModelMapper;
import com.example.colossaltitan.model.Exercise;
import com.example.colossaltitan.model.Workout;
import com.example.colossaltitan.repository.ExerciseRepository;
import com.example.colossaltitan.repository.WorkoutRepository;
import com.example.colossaltitan.service.WorkoutService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class WorkoutServiceImpl implements WorkoutService {

    private WorkoutRepository workoutRepository;
    private ExerciseRepository exerciseRepository;
    private ModelMapper mapper;


    @Override
    public WorkoutDTO addWorkout(WorkoutDTO workoutDTO) {
        Workout workout = mapper.fromDTOToWorkout(workoutDTO);
        Workout savedWorkout = workoutRepository.save(workout);
        return mapper.fromWorkoutToDTO(savedWorkout);
    }

    @Override
    public void deleteWorkout(Long id) throws WorkoutNotFoundException {
        Workout workout = workoutRepository.findWorkoutByWorkoutId(id)
                .orElseThrow(()-> new WorkoutNotFoundException("workout not found " + id));
        workoutRepository.delete(workout);
    }

    @Override
    public void addExerciseToWorkout(Long exerciseID, Long workoutID) throws ExerciseNotFoundException, WorkoutNotFoundException {
        Workout workout = workoutRepository.findWorkoutByWorkoutId(workoutID)
                .orElseThrow(()->new WorkoutNotFoundException("workout not found"));
        Exercise exercise = exerciseRepository.findExerciseByExerciseId(exerciseID)
                .orElseThrow(()-> new ExerciseNotFoundException("exercise not found"));
        workout.getExercise().add(exercise);
        workoutRepository.save(workout);
    }


    @Override
    public List<WorkoutDTO> workoutList() throws WorkoutListIsEmptyException {
        List<Workout> workouts = workoutRepository.findAll();
        if (workouts.size() < 1) throw new WorkoutListIsEmptyException("workout list is empty");
        return workouts.stream().map(wr -> mapper.fromWorkoutToDTO(wr)).collect(Collectors.toList());

    }
}
