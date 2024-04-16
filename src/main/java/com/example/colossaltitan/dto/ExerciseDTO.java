package com.example.colossaltitan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExerciseDTO {


    private String exercise_name;
    private String description_url;
    private String exercise_image;
    private String muscle_group;
    private String equipment;
    private String rating;
    private String description;
}
