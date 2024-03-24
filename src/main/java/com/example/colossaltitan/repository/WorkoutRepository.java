package com.example.colossaltitan.repository;

import com.example.colossaltitan.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {

    Optional<Workout> findWorkoutByWorkoutId(Long id);
}
