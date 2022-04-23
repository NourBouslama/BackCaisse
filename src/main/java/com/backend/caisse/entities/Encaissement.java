package com.backend.caisse.entities;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class Encaissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idE;
    private Date dateE=new Date();
    private double montantE;
    private String etat = "payer";
    
    @JsonIgnore
    @OneToOne(mappedBy="encaissement")
    private Paiement paiement;
    
    @ManyToOne
    private SessionCaisse session;
    
    public Encaissement(Object object, Date date, Double montant) {
    }

    public Encaissement(Date dateE, double montantE) {

        this.dateE = dateE;
        this.montantE = montantE;

    }

    public Encaissement(Date object, double mt, List<Paiement> paie) {
    }

}
