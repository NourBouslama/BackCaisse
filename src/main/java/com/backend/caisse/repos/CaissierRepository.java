package com.backend.caisse.repos;

import java.util.List;

import com.backend.caisse.entities.Caissier;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CaissierRepository extends JpaRepository<Caissier, Long> {
	@Transactional
	@Modifying
	@Query("update Caissier p set p.etat ='activé' where p.idU = ?1")
	void updateEtatAct(long idU);

	@Transactional
	@Modifying
	@Query("update Caissier p set p.etat ='desactivé' where p.idU = ?1")
	void updateEtatDesact(long idU);

	List<Caissier>findByEtat(String etat);

	Caissier findByIdU(Long id);

}
