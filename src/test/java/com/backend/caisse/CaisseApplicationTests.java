package com.backend.caisse;

import java.util.List;

import com.backend.caisse.entities.Caisse;
import com.backend.caisse.entities.ModePaiement;
import com.backend.caisse.repos.CaisseRepository;
import com.backend.caisse.repos.ModeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaisseApplicationTests {

	/*@Test
	void contextLoads() {
	}*/

	@Autowired
    private CaisseRepository caisseRepository;

	@Autowired
    private ModeRepository modeRepository;

	@Test
    public void testdesactiverEtat() {
    //Caisse prod = new Livre("apprendre à aimer",25,"fff");
    //livreRepository.save(prod);
	Caisse c=new Caisse();
	caisseRepository.save(c);
	caisseRepository.updateEtatAct(2);
	}
	@Test
    public List<ModePaiement> testactiv() {
    //Caisse prod = new Livre("apprendre à aimer",25,"fff");
    //livreRepository.save(prod);
	/*ModePaiement mode=new ModePaiement();
	modeRepository.save(mode);*/
	return modeRepository.findByEtatM("active");

	}
	

}
