package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Caissier;

public interface CaissierService {

    Caissier ajouterCaissier(Caissier p);

    Caissier modifierCaissier(Caissier p);

    Caissier desactiverCaissierByMat(Long id);

    Caissier activerCaissierByMat(Long id);

    Caissier consulterCaissier(Long id);

    List<Caissier> listerCaissiers();

    List<Caissier> listerCaissiersByEtat(String etat);
    
}
