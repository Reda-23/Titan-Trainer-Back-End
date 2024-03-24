package com.example.colossaltitan.dto;

import com.example.colossaltitan.enums.SubscriptionStatus;
import com.example.colossaltitan.enums.SubscriptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubscriptionDTO {

    private double price;
    private SubscriptionStatus status;
    private SubscriptionType type;
    private Date startDate;
    private Date endDate;
}
