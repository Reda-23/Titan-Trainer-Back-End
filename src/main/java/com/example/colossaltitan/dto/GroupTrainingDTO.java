package com.example.colossaltitan.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data

@NoArgsConstructor
public class GroupTrainingDTO {

    private String name;
    private int numberOfPlaces;
    private int numberOfPlacesLeft;
    private LocalDate groupTrainingDay;
    private int startingHour;
    private int endingHour;

    public GroupTrainingDTO(String name, int numberOfPlaces, LocalDate groupTrainingDay, int startingHour, int endingHour) {
        this.name = name;
        this.numberOfPlaces = numberOfPlaces;
        this.groupTrainingDay = groupTrainingDay;
        this.startingHour = startingHour;
        this.endingHour = endingHour;
    }
}
