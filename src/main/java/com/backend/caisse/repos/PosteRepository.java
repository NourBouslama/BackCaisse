package com.backend.caisse.repos;

import com.backend.caisse.entities.Poste;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PosteRepository extends JpaRepository<Poste, Long> {
    Poste findByPoste(String poste);
    
}
