package com.backend.caisse.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;



@Data
@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCli;
    private Long referenceClient;
    private String nom;
    private String prenom;
    
    @JsonIgnore
    @OneToMany(mappedBy = "cli")
    private List<Paiement> paiements;
    
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Facture> factures;
    
}
