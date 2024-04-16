package com.example.colossaltitan.repository;

import com.example.colossaltitan.model.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<Exercise,Long> {

    Optional<Exercise> findExerciseByExerciseId(Long id);

    @Query( value = "select e from Exercise e where lower(e.exercise_name) like lower(concat('%', ?1,'%')) ")
    List<Exercise> searchExercisesByName(String exercise_name);


}
