package com.example.colossaltitan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Entity
@Table(name = "EXERCISE")
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long exerciseId;
    private String exercise_name;
    private String description_url;
    private String exercise_image;
    private String muscle_group;
    private String equipment;
    private String rating;
    private String description;
}
