package com.backend.caisse.serviceImp;

import javax.transaction.Transactional;

import com.backend.caisse.entities.Poste;
import com.backend.caisse.entities.Utilisateur;
import com.backend.caisse.repos.PosteRepository;
import com.backend.caisse.repos.UtilisateurRepository;
import com.backend.caisse.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class UtilisateurServiceImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepository utilisateurRep;

    @Autowired
    PosteRepository posteRep;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Utilisateur AjouterUtilisateur(Utilisateur u) {
        u.setMotDePasse(bCryptPasswordEncoder.encode(u.getMotDePasse()));
        return utilisateurRep.save(u);
        
    }

    @Override
    public Utilisateur chercherParPrenom(String prenom) {
        return utilisateurRep.findByPrenom(prenom);
        
    }

    @Override
    public Poste AjoueterPoste(Poste poste) {
        return posteRep.save(poste);
    }

    @Override
    public Utilisateur AjouterPosteaUtilisateur(String prenom, String poste) {
        Utilisateur usr = utilisateurRep.findByPrenom(prenom);
        Poste r = posteRep.findByPoste(poste);
        usr.getPostes().add(r);
        return usr;
    }
    
}
