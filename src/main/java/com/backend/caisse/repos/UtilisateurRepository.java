package com.backend.caisse.repos;

import com.backend.caisse.entities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByPrenom(String prenom);
    
}
