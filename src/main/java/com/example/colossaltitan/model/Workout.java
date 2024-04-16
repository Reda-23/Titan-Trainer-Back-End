package com.example.colossaltitan.model;

import com.example.colossaltitan.enums.Workout_Level;
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
    @Lob
    private String note;
    @Enumerated(value = EnumType.STRING)
    private Workout_Level level;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Exercise> exercise;
}
