package com.example.colossaltitan.dto;

import com.example.colossaltitan.enums.Gender;
import com.example.colossaltitan.enums.Language;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {

    private String clientName;
    private String imageUrl;
    private String clientEmail;
    private String password;
    private double walletBalance;
    private String phoneNumber;
    private double height;
    private double weight;
    private Gender gender;
    private Date birthDate;
    private Language language;
    private String address;
    private String city;
}
