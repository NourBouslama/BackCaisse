package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.ModePaiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CaisseRepository extends JpaRepository<Caisse, Long> {


	/*List<Caisse> findByModes(ModePaiement mode);

	List<Caisse> findByModesCode(Long code);*/

	@Transactional
	@Modifying
	@Query("update Caisse p set p.etat = 'activé' where p.idC = ?1")
	void updateEtatAct(long idC);

	@Transactional
	@Modifying
	@Query("update Caisse p set p.etat ='desactivé' where p.idC = ?1")
	void updateEtatDesact(long idC);

	Caisse findByIdC(Long id);

	List<Caisse>findByEtat(String etat);

	List<Caisse>findBySessionsEtat(String etat);
}