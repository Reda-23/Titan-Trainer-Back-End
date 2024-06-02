package com.example.colossaltitan;

import com.example.colossaltitan.dto.ClientDTO;
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
            ClientDTO client1 = new ClientDTO("reda","-----","reda@gmail.com","1234",0.0,"06443332",186,96, Gender.MALE,new Date(), Language.ARABIC,"3 rue abou doud","Fes");
            ClientDTO client2 = new ClientDTO("tipo","-----","tipo@gmail.com","1234",0.0,"06443332",186,96, Gender.MALE,new Date(), Language.ARABIC,"3 rue abou doud","Fes");
             GroupTrainingDTO groupTrainingDTO = new GroupTrainingDTO("YOGA",35,LocalDate.now(),10,11);
             workoutService.addWorkout(new WorkoutDTO(null,"Chest 101",60,"chest beginner workout for a crazy pump ",Workout_Level.Hard,false));
             workoutService.addWorkout(new WorkoutDTO(null,"Back 102",60,"back  workout for a crazy pump ",Workout_Level.Medium,true));
            clientService.addClient(client1);
            clientService.addClient(client2);

            groupTrainingService.addGroupTraining(groupTrainingDTO);


            try {

                walletService.fillWallet(1L,2800);


                groupTrainingService.bookGroupTraining(1L,1L);
            } catch ( ClientNotFoundException |
                     CannotFillTheWalletWithNegativeAmountException | ClientHasAlreadyBookedThisGroupTrainingException e) {
                throw new RuntimeException(e);
            }




        };
   }
}
