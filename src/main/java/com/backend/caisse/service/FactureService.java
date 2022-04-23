package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;

public interface FactureService {
    
    List<Facture> ChercherFactureParReferenceContrat(Long rfc);

    List<Facture> ChercherFactureParReferenceClient(Long rf);

    List<Facture> ChercherFactureParReferenceFacture(Long ff);

    void modifierFacture(Paiement paiement, Long ref);

    void annulerPaiementFacture(Long referenceFact);
}
