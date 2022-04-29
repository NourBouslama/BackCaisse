package com.backend.caisse.service;

import javax.transaction.Transactional;

import com.backend.caisse.entities.Poste;
import com.backend.caisse.entities.Utilisateur;

@Transactional
public interface UtilisateurService {
    Utilisateur AjouterUtilisateur(Utilisateur u);
    Utilisateur chercherParPrenom (String prenom);
    Poste AjoueterPoste(Poste poste);
    Utilisateur AjouterPosteaUtilisateur(String prenom, String poste);
}
