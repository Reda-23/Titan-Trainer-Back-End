package com.example.colossaltitan.model;

import com.example.colossaltitan.enums.SubscriptionStatus;
import com.example.colossaltitan.enums.SubscriptionType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "SUBSCRIPTION")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subscriptionId;
    private double price;
    private SubscriptionStatus status;
    private SubscriptionType type;
    private Date startDate;
    private Date endDate;
    @OneToMany(mappedBy = "subscription")
    private List<Client> clients;
}
