package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;

public interface PaiementService {
  
  List<Paiement> ListerPaiements(Long numS);

  Paiement AnnulerPaiementFacture(List<Facture> fact);

  Paiement PaiementFactureAgent(List<Facture> factures,Long p);

  Paiement ajouterPaiement(Paiement p);

  Paiement paiementFactureCaissier(List<Facture> factures,Long idP);
}
