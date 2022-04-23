package com.backend.caisse.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
public class Paiement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idP;
    private Date dateP;
    private String modePaiement;
    private String etat="payé";
  

    @OneToOne
    @JoinColumn(name="encaissement_id",referencedColumnName = "idE")
    private Encaissement encaissement;

    @JsonIgnore
    @OneToMany(mappedBy = "paiement")
    private List<Facture> factures;

    @ManyToOne
    private Agent agent;

    @ManyToOne
    private Client cli;
}
