package com.backend.caisse.service;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;

public interface SessionService {

    SessionCaisse CreerSessionCaisse(SessionCaisse p);

    SessionCaisse fermerSessionParNum(Long nums);

    SessionCaisse OuvrirSessionParNum(Long nums);

    SessionCaisse consulterSessionCaisse(Long id);

    List<SessionCaisse> listerSessionCaisses();
    
    SessionCaisse fermerJournalCaisse(Long id);

    List<SessionCaisse>listerSessionParEncaissementEtat(String etat);

    List<SessionCaisse> chercherParCaisseNumC(String etat,Long id);

    List<SessionCaisse> chercherParCaissierId(Long id);

    List<SessionCaisse> chercherParEtatETCaissier(String etat,Long id);

    SessionCaisse chercherParCaissierEtEtat(Long id,String etat);

    void modifierSessionParMontantEtNbFacture(double d, Long nbF, Long numc);

    void annulerSession(double mt, Long numS);

    

}
