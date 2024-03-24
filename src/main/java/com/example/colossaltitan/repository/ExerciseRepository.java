package com.example.colossaltitan.repository;

import com.example.colossaltitan.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise,Long> {

    Optional<Exercise> findExerciseByExerciseId(Long id);
}