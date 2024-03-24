package com.example.colossaltitan.model;

import com.example.colossaltitan.enums.Gender;
import com.example.colossaltitan.enums.Language;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String clientName;
    private String imageUrl;
    private String clientEmail;
    private String password;
    private double walletBalance;
    private String phoneNumber;
    private double height;
    private double weight;
    @Enumerated(value = EnumType.STRING)
    private Gender gender;
    private Date birthDate;
    @Enumerated(value = EnumType.STRING)
    private Language language;
    private String address;
    private String city;
    @ManyToOne
    @JoinColumn(name = "subscription_id")
    private Subscription subscription;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Workout> workouts;
    @ManyToOne
    private GroupTraining groupTraining;









}
