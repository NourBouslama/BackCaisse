package com.backend.caisse.serviceImp;

import java.util.List;


import com.backend.caisse.entities.Caisse;
import com.backend.caisse.repos.CaisseRepository;
import com.backend.caisse.service.CaisseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaisseServiceImpl implements CaisseService {

    @Autowired
    private CaisseRepository caisseRepository;


    @Override
    public Caisse ajouterCaisse(Caisse p) {

        return caisseRepository.save(p);
    }

    @Override
    public Caisse modifierCaisse(Caisse p) {

        return caisseRepository.save(p);
    }

    @Override
    public Caisse desactiverCaisseById(Long numc) {

        caisseRepository.updateEtatDesact(numc);
        return caisseRepository.findByIdC(numc);
     

    }

    @Override
    public Caisse activerCaisseById(Long numc) {

        caisseRepository.updateEtatAct(numc);
        return caisseRepository.findByIdC(numc);
    }

    @Override
    public Caisse consulterCaisse(Long numc) {

        return caisseRepository.findById(numc).get();
    }

    @Override
    public List<Caisse> listerCaisses() {

        return caisseRepository.findAll();
    }

 

    @Override
    public List<Caisse> listerCaissesParEtat(String etat) {

        return caisseRepository.findByEtat(etat);
    }

    @Override
    public List<Caisse> listerCaissesParSessionsEtat(String etat) {
        // TODO Auto-generated method stub
        return caisseRepository.findBySessionsEtat(etat);
    }

 
  

}
