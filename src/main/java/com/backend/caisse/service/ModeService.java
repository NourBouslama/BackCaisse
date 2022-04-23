package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.ModePaiement;

public interface ModeService {

    ModePaiement ajouterModePaiement(ModePaiement p);

    ModePaiement modifierModePaiement(ModePaiement p);

    ModePaiement desactiverModePaiementById(Long code);

    ModePaiement activerModePaiementById(Long code);

    List<ModePaiement> listerModePaiements();

    List<ModePaiement> listerModePaiementParEtat(String etat);

    ModePaiement consulterModePaiement(Long id);

  
}
