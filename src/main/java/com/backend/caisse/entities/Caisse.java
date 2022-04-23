package com.backend.caisse.entities;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.JoinColumn;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Caisse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idC;
    private Long numC;
    private String etat="activé";
    private String intitule;
    
    
    @JsonIgnore
    @OneToMany(mappedBy = "caisse")
    private List<SessionCaisse> sessions;
  
    @ManyToMany
    @JoinTable(
        name="affecter_mode",
        joinColumns = @JoinColumn(name="caisse_id"),
        inverseJoinColumns = @JoinColumn(name="mode_id")
    )
    private List<ModePaiement> modes;
    
  
 
    
}
