package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Encaissement;
import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.repos.EncaissementRepository;
import com.backend.caisse.service.EncaissementService;
import com.backend.caisse.service.SessionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EncaissementServiceImpl implements EncaissementService{

    @Autowired
    private EncaissementRepository encaissementRepository;

    @Autowired
    SessionService sessionService;

    @Override
    public List<Encaissement> listerEncaissements() {
   
        return encaissementRepository.findAll();
    }

    @Override
    public List<Encaissement> listerEncaissementsParSession(Long nums) {
        
        return encaissementRepository.findBySessionNumS(nums);
    }

    @Override
    public List<Encaissement> listerEncaissementParEtatEtPaiementMode(String e,String m) {
        
        return encaissementRepository.findByEtatAndPaiementModePaiement(e,m);
    }

    @Override
    public List<Encaissement> listerEncaissementsParEtatETSession(String etat, Long nums) {
     
        return encaissementRepository.findByEtatAndSessionNumS(etat, nums);
    }

    @Override
    public Encaissement ajouterEncaissement(Encaissement encaissement) {
        SessionCaisse sessionCaisse=encaissement.getSession();
        sessionService.modifierSessionParMontantEtNbFacture(encaissement.getMontantE(),sessionCaisse.getNbFacture(),sessionCaisse.getNumS());

       return encaissementRepository.save(encaissement);
    }

    @Override
    public void annulerEncaissement(Long idE) {
        encaissementRepository.EncaissementEtatAnnuler(idE);
        
    }
    
}
