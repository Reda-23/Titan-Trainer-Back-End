package com.example.colossaltitan;

import com.example.colossaltitan.dto.ClientDTO;
import com.example.colossaltitan.dto.ExerciseDTO;
import com.example.colossaltitan.dto.GroupTrainingDTO;
import com.example.colossaltitan.dto.WorkoutDTO;
import com.example.colossaltitan.enums.*;
import com.example.colossaltitan.exception.*;
import com.example.colossaltitan.model.Client;
import com.example.colossaltitan.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ColossalTitanApplication  {

    public static void main(String[] args) {
        SpringApplication.run(ColossalTitanApplication.class, args);
    }

    @Bean
   public CommandLineRunner runner(ClientService clientService,
                                   WorkoutService workoutService,
                                   ExerciseService exerciseService , WalletService walletService,
                                   GroupTrainingService groupTrainingService){
        return args -> {
            ClientDTO clientDTO = new ClientDTO("reda","-----","reda@gmail.com","1234",0.0,"06443332",186,96, Gender.MALE,new Date(), Language.ARABIC,"3 rue abou doud","Fes");
            WorkoutDTO workoutDTO = new WorkoutDTO("PPL",90, WorkoutType.Strength_Training, WorkoutLevel.Vigorous,"this is the first workout ");
            ExerciseDTO exerciseDTO = new ExerciseDTO("Incline Dumbbell Press",WorkoutType.Strength_Training, Muscles.CHEST, Materials.BARBELL);
            ExerciseDTO exerciseDTO2 = new ExerciseDTO("Barbell Row",WorkoutType.Strength_Training, Muscles.BACK, Materials.MACHINE);
            GroupTrainingDTO groupTrainingDTO = new GroupTrainingDTO("YOGA",35,LocalDate.now(),10,11);
            workoutService.addWorkout(workoutDTO);
            clientService.addClient(clientDTO);
            exerciseService.addExercise(exerciseDTO);
            exerciseService.addExercise(exerciseDTO2);
            groupTrainingService.addGroupTraining(groupTrainingDTO);


            try {
                workoutService.addExerciseToWorkout(1L,1L);
                walletService.fillWallet(1L,2800);
                workoutService.addExerciseToWorkout(2L,1L);
                clientService.addWorkoutToClient(1L,1L);
                groupTrainingService.bookGroupTraining(1L,1L);
            } catch (ExerciseNotFoundException | WorkoutNotFoundException | ClientNotFoundException |
                     CannotFillTheWalletWithNegativeAmountException | ClientHasAlreadyBookedThisGroupTrainingException e) {
                throw new RuntimeException(e);
            }




        };
   }
}
