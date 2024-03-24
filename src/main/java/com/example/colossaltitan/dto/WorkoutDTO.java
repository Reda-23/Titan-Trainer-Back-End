package com.example.colossaltitan.dto;

import com.example.colossaltitan.enums.WorkoutLevel;
import com.example.colossaltitan.enums.WorkoutType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkoutDTO {

    private String workoutName;
    private int duration;
    private WorkoutType workoutType;
    private WorkoutLevel workoutLevel;
    private String note;










}
