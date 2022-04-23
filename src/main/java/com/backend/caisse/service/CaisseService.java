package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.ModePaiement;

public interface CaisseService {

    Caisse ajouterCaisse(Caisse p);

    Caisse modifierCaisse(Caisse p);

    Caisse desactiverCaisseById(Long id);

    Caisse activerCaisseById(Long id);

    Caisse consulterCaisse(Long id);

    List<Caisse> listerCaisses();

    List<Caisse> listerCaissesParEtat(String etat);

    List<Caisse> listerCaissesParSessionsEtat(String etat);

    
}
