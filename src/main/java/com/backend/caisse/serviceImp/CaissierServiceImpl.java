package com.backend.caisse.serviceImp;

import java.util.List;

import com.backend.caisse.entities.Caissier;
import com.backend.caisse.repos.CaissierRepository;
import com.backend.caisse.service.CaissierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaissierServiceImpl implements CaissierService {

    @Autowired
    private CaissierRepository caissierRepository;

    @Override
    public Caissier ajouterCaissier(Caissier p) {

        return caissierRepository.save(p);
    }

    @Override
    public Caissier modifierCaissier(Caissier p) {

        return caissierRepository.save(p);
    }

    @Override
    public Caissier desactiverCaissierByMat(Long id) {

        caissierRepository.updateEtatDesact(id);
        return caissierRepository.findByIdU(id);
    }

    @Override
    public Caissier activerCaissierByMat(Long id) {

        caissierRepository.updateEtatAct(id);
        return caissierRepository.findByIdU(id);
    }

    @Override
    public Caissier consulterCaissier(Long mat) {

        return caissierRepository.findById(mat).get();
    }

    @Override
    public List<Caissier> listerCaissiers() {

        return caissierRepository.findAll();
    }

    @Override
    public List<Caissier> listerCaissiersByEtat(String etat) {
    
        return caissierRepository.findByEtat(etat);
    }

}
