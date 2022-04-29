package com.backend.caisse.entities;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idU;
    private String matricule;
    private String nom;
    private String prenom;
    private String email;
  //  private String poste;
    private String adresse;
    private String etat = "activé";
    private String motDePasse;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name="affecte_poste",
        joinColumns = @JoinColumn(name="utilisateur_id"),
        inverseJoinColumns = @JoinColumn(name="poste_id")
    )
    private List<Poste> postes;
    

    @ManyToOne
    private Role role;
    
}
