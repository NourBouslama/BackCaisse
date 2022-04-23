package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;
import com.backend.caisse.service.CaissierService;
import com.backend.caisse.service.SessionService;
import com.backend.caisse.repos.SessionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionRepository SessionRepository;

    @Override
    public SessionCaisse CreerSessionCaisse(SessionCaisse s) {

        return SessionRepository.save(s);
    }

    @Override
    public SessionCaisse fermerSessionParNum(Long nums) {

        SessionRepository.updateEtatFermer(nums);
        return SessionRepository.findByNumS(nums);
    }

    @Override
    public SessionCaisse consulterSessionCaisse(Long id) {

        return SessionRepository.findById(id).get();
    }

    @Override
    public List<SessionCaisse> listerSessionCaisses() {

        return SessionRepository.findAll();
    }


    @Override
    public List<SessionCaisse> chercherParCaisseNumC(String etat,Long numc) {

        return SessionRepository.findByEtatAndCaisseNumC(etat,numc);
    }

  

    @Override
    public List<SessionCaisse> chercherParEtatETCaissier(String etat,Long mat) {

        return SessionRepository.findByEtatAndCaissierIdU(etat,mat);
    }

    @Override
    public SessionCaisse OuvrirSessionParNum(Long nums) {

        
        SessionRepository.updateEtatOuvrir(nums);
        return SessionRepository.findByNumS(nums);
        
    }

    @Override
    public SessionCaisse fermerJournalCaisse(Long numc) {
     
        SessionRepository.updateEtatJournal(numc);
        return SessionRepository.findByNumS(numc);
        
    }

    @Override
    public List<SessionCaisse> listerSessionParEncaissementEtat(String etat) {
        // TODO Auto-generated method stub
        return SessionRepository.findByEncaissementsEtat(etat);
    }

    @Override
    public List<SessionCaisse> chercherParCaissierId(Long id) {
        // TODO Auto-generated method stub
        return SessionRepository.findByCaissierIdU(id);
    }

    @Override
    public void modifierSessionParMontantEtNbFacture(double d, Long nbF, Long numc) {
        SessionRepository.updateSessionMontantAndNbFacture(d,nbF,numc); 
        
    }

    @Override
    public void annulerSession(double mt, Long numS) {
        SessionRepository.AnnulerSessionMontantAndNbFacture(mt,  numS);
        
    }

    @Override
    public SessionCaisse chercherParCaissierEtEtat(Long id,String etat) {
        // TODO Auto-generated method stub
        return SessionRepository.findByCaissierIdUAndEtat(id,etat);
    }

    /*@Override
    public void updateDateFermetureById(Long nums) {
        
        SessionRepository.updateDateFermeture(nums);
        
    }*/

}
