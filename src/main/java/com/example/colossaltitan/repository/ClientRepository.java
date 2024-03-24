package com.example.colossaltitan.repository;

import com.example.colossaltitan.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client,Long> {


    Optional<Client> getClientByClientId(Long id);
}
