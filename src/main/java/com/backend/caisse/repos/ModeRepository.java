package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.ModePaiement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ModeRepository extends JpaRepository <ModePaiement, Long> {
    @Transactional
	@Modifying
	@Query("update ModePaiement p set p.etatM = 'activé' where p.code = ?1")
	void updateEtatAct(long code);

	@Transactional
	@Modifying
	@Query("update ModePaiement p set p.etatM ='desactivé' where p.code = ?1")
	void updateEtatDesact(long code);

    ModePaiement findByCode(Long code);

	List<ModePaiement>findByEtatM(String etat);
}
