package com.backend.caisse.repos;

import com.backend.caisse.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
    
    Client findByReferenceClient(Long ref);   
}
