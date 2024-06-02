package com.example.colossaltitan.dto;

import com.example.colossaltitan.enums.Workout_Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDTO {

    private Long workoutId;
    private String workoutName;
    private int duration;
    private String note;
    private Workout_Level level;
    private boolean isFavorite;










}
