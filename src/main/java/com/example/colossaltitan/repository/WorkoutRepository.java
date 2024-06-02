package com.example.colossaltitan.repository;

import com.example.colossaltitan.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface WorkoutRepository extends JpaRepository<Workout,Long> {

    Optional<Workout> findWorkoutByWorkoutId(Long id);


    @Query("SELECT w from Workout w where w.isFavorite = true ")
    List<Workout> findAllWorkoutIsFavoriteEqualToTrue();



}
