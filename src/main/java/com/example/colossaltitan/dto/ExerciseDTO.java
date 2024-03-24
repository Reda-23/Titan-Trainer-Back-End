package com.example.colossaltitan.dto;

import com.example.colossaltitan.enums.Materials;
import com.example.colossaltitan.enums.Muscles;
import com.example.colossaltitan.enums.WorkoutType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {


    private String exoName;
    private WorkoutType workoutType;
    private Muscles muscles;
    private Materials materials;
}
