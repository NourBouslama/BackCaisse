package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.SessionCaisse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface SessionRepository extends JpaRepository<SessionCaisse, Long> {

	@Query("select count(*) from SessionCaisse p where p.etat=?1 and  p.caisse = ?2")
    Long findByEtatAndCaisse(String etat,Caisse caisse);
    
	List<SessionCaisse>  findByEtatAndCaisseNumC(String etat,Long numc);

	List<SessionCaisse> findByCaissierIdU(Long id);

	List<SessionCaisse> findByEtatAndCaissierIdU(String etat,Long id);

	SessionCaisse findByCaissierIdUAndEtat(Long id,String etat);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.etat='fermer' ,p.datefermeture=NOW()  where p.numS = ?1")
	void updateEtatFermer(long nums);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.etat='en cours',p.dateOuverture=NOW(),p.datefermeture=DEFAULT,etatJournal=DEFAULT   where p.numS = ?1")
	void updateEtatOuvrir(long nums);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.etatJournal ='fermer'where p.numS = ?1")
	void updateEtatJournal(long numc);

	List<SessionCaisse>findByEncaissementsEtat(String etat);

	SessionCaisse findByNumS(Long nums);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.montantSession =p.montantSession + ?1 , p.nbFacture=?2 where p.numS = ?3")
	void updateSessionMontantAndNbFacture(double mt,Long nbF, Long numc);

	@Transactional
	@Modifying
	@Query("update SessionCaisse p set p.montantSession =p.montantSession - ?1 , p.nbFacture= p.nbFacture -1 where p.numS = ?2")
	void AnnulerSessionMontantAndNbFacture(double mt, Long numc);

}
