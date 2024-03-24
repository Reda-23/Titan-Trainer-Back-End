package com.example.colossaltitan.model;

import com.example.colossaltitan.enums.WorkoutLevel;
import com.example.colossaltitan.enums.WorkoutType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "WORKOUT")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long workoutId;
    private String workoutName;
    private int duration;
    @Enumerated(value = EnumType.STRING)
    private WorkoutType workoutType;
    @Enumerated(value = EnumType.STRING)
    private WorkoutLevel workoutLevel;
    @Lob
    private String note;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Exercise> exercise;
}
