package com.example.colossaltitan.repository;


import com.example.colossaltitan.enums.Gender;
import com.example.colossaltitan.model.Client;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;


@DataJpaTest
public class ClientRepositoryTest {

    @Autowired
    private ClientRepository clientRepository;

    private Client client;

    @BeforeEach
    public void initClient(){
        client = Client.builder()
                .clientName("reda")
                .clientEmail("reda@gmail.com")
                .height(186)
                .gender(Gender.MALE)
                .build();
    }

    // Given When Then Pattern



    @Test
    @DisplayName("JUnit Test for save client method")
    public void givenClientObject_WhenSave_ReturnClient(){
        Client savedClient = clientRepository.save(client);
        assertThat(savedClient).isNotNull();
        assertThat(savedClient.getClientName()).isEqualTo("reda");
    }

    @Test
    @DisplayName("JUnit Test for getClientById method")
    public void givenClientObject_WhenGetClientById_ThenReturnClient(){
            clientRepository.save(client);
        Client getClient = clientRepository.getClientByClientId(1L).get();
        assertThat(getClient).isNotNull();
        assertThat(getClient.getClientId()).isEqualTo(1L);
    }

    @Test
    @DisplayName("JUnit Test for findAll method")
    public void givenClientList_WhenFinAll_ThenReturnClientList(){
        Client client2 = Client.builder()
                .clientName("jack")
                .city("London")
                .build();
        clientRepository.save(client);
        clientRepository.save(client2);

        List<Client> clients = clientRepository.findAll();

        assertThat(clients).isNotEmpty();
        assertThat(clients.size()).isEqualTo(2);

    }

}
