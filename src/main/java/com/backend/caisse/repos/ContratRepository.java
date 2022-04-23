package com.backend.caisse.repos;

import com.backend.caisse.entities.Contrat;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratRepository extends JpaRepository<Contrat, Long>{
    Contrat findByReferenceContrat(Long ref);
}
