package com.example.colossaltitan.mapper;

import com.example.colossaltitan.dto.*;
import com.example.colossaltitan.model.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ModelMapper {


    public Client fromDTOToClient(ClientDTO clientDTO){
        Client client = new Client();
        BeanUtils.copyProperties(clientDTO,client);
        return client;
    }

    public ClientDTO fromClientToDTO(Client client){
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client,clientDTO);
        return clientDTO;
    }


    public Workout fromDTOToWorkout(WorkoutDTO workoutDTO){
        Workout workout =new Workout();
        BeanUtils.copyProperties(workoutDTO,workout);
        return workout;
    }
    public WorkoutDTO fromWorkoutToDTO(Workout workout){
        WorkoutDTO workoutDTO = new WorkoutDTO();
        BeanUtils.copyProperties(workout,workoutDTO);
        return workoutDTO;
    }


    public Subscription fromDTOToSubscription(SubscriptionDTO subscriptionDTO){
        Subscription subscription = new Subscription();
        BeanUtils.copyProperties(subscriptionDTO,subscription);
        return subscription;
    }


    public SubscriptionDTO fromSubscriptionToDTO(Subscription subscription){
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        BeanUtils.copyProperties(subscription,subscriptionDTO);
        return subscriptionDTO;
    }


    public GroupTraining fromDTOToGroupTraining(GroupTrainingDTO groupTrainingDTO){
        GroupTraining groupTraining = new GroupTraining();
        BeanUtils.copyProperties(groupTrainingDTO,groupTraining);
        return groupTraining;
    }

    public GroupTrainingDTO fromGroupTrainingToDTO(GroupTraining groupTraining){
        GroupTrainingDTO groupTrainingDTO = new GroupTrainingDTO();
        BeanUtils.copyProperties(groupTraining,groupTrainingDTO);
        return groupTrainingDTO;
    }

    public Exercise fromDTOToExercise(ExerciseDTO exerciseDTO){
        Exercise exercise = new Exercise();
        BeanUtils.copyProperties(exerciseDTO,exercise);
        return exercise;
    }

    public ExerciseDTO fromExerciseToDTO(Exercise exercise){
        ExerciseDTO exerciseDTO = new ExerciseDTO();
        BeanUtils.copyProperties(exercise,exerciseDTO);
        return exerciseDTO;
    }

}
