package com.example.colossaltitan.model;

import com.example.colossaltitan.enums.Materials;
import com.example.colossaltitan.enums.Muscles;
import com.example.colossaltitan.enums.WorkoutType;
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
    private String exoName;
    @Enumerated(value = EnumType.STRING)
    private WorkoutType workoutType;
    @Enumerated(value = EnumType.STRING)
    private Muscles muscles;
    @Enumerated(value = EnumType.STRING)
    private Materials materials;
}
