package com.example.colossaltitan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "GROUP_TRAINING")
public class GroupTraining {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long groupTrainingId;
    private String name;
    private int numberOfPlaces;
    private int numberOfPlacesLeft;
    private LocalDate groupTrainingDay;
    private int startingHour;
    private int endingHour;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Client> clients;
}
