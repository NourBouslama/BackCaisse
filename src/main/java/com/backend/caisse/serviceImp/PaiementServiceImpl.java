package com.backend.caisse.serviceImp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.Client;
import com.backend.caisse.entities.Contrat;
import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.Facture;
import com.backend.caisse.entities.Paiement;
import com.backend.caisse.repos.ClientRepository;
import com.backend.caisse.repos.ContratRepository;
import com.backend.caisse.repos.EncaissementRepository;
import com.backend.caisse.repos.FactureRepository;
import com.backend.caisse.repos.PaiementRepository;
import com.backend.caisse.service.EncaissementService;
import com.backend.caisse.service.FactureService;
import com.backend.caisse.service.PaiementService;
import com.backend.caisse.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaiementServiceImpl implements PaiementService {

    @Autowired
    PaiementRepository paiementRepository;

    @Autowired
    FactureService factureService;

    @Autowired
    EncaissementService encaissementService;

    @Autowired
    SessionService sessionService;

    @Override
    public Paiement PaiementFactureAgent(List<Facture> factures, Long p) {

Paiement paiement = paiementRepository.findByIdP(p);
        for (Facture f : factures) {

            factureService.modifierFacture(paiement, f.getReferenceFact());
            paiementRepository.updatePaiement(paiement.getAgent(), paiement.getIdP());

        }
        return paiement;
    }
    
    @Override
    public Paiement AnnulerPaiementFacture(List<Facture> fact) {
        Paiement p = new Paiement();
boolean test=false;
        for (Facture f : fact) {
            p = f.getPaiement();

            if (factureService.chercherPaiementFacture(p) > 1) {
               // sessionService.annulerSession(f.getMontant(), p.getEncaissement().getSession().getNumS());
                Encaissement encaissement = encaissementService.ajouterEncaissement(new Encaissement(null, new Date(),
                        f.getMontant(), "annuler", null, p.getEncaissement().getSession()));
                paiementRepository.save(
                        new Paiement(null, new Date(), p.getModePaiement(), "annuler", encaissement, null, null, null));
                // encaissement.setEtat('annulé');
             //   factureService.annulerPaiementFacture(f.getReferenceFact());
                test=true;
            }
          

          
            factureService.annulerPaiementFacture(f.getReferenceFact());

            sessionService.annulerSession(f.getMontant(), p.getEncaissement().getSession().getNumS());  
        }
        if(test==false){

            paiementRepository.annulerPaiement(p.getIdP());
            encaissementService.annulerEncaissement(p.getEncaissement().getIdE());
        }


        return p;
    }

  /*  @Override
    public Paiement AnnulerPaiementFacture(List<Facture> fact) {
        Paiement p = new Paiement();
      
        for (Facture f : fact) {
            factureService.annulerPaiementFacture(f.getReferenceFact());
            p = f.getPaiement();
           
            sessionService.annulerSession(f.getMontant(),p.getEncaissement().getSession().getNumS());
        }
       
        paiementRepository.annulerPaiement(p.getIdP());
        encaissementService.annulerEncaissement(p.getEncaissement().getIdE());
    
return p;
    }*/


    @Override
    public List<Paiement> ListerPaiements(Long numS) {

        List<Paiement> paiements= new ArrayList<>();
        List<Encaissement> lEncaissements=encaissementService.listerEncaissementsParSession(numS);
        for(Encaissement e: lEncaissements)
        {
            paiements.add(paiementRepository.findByEncaissementIdE(e.getIdE()));
            
        }
        return paiements;
    }

    @Override
    public Paiement ajouterPaiement(Paiement p) {
        Paiement paie= paiementRepository.save(p);
        paiementRepository.updateEncaissementPaiement(p.getEncaissement(), paie.getIdP());
return paie;
    }

    @Override
    public Paiement paiementFactureCaissier(List<Facture> factures) {

        Paiement paiement = new Paiement();

        for (Facture f : factures) {
            paiement = f.getPaiement();
            factureService.modifierFacture(paiement, f.getReferenceFact());

        }

        return paiement;
    }

  
 
}