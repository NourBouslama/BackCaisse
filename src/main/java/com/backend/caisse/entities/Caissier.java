package com.backend.caisse.entities;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.OneToMany;

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
public class Caissier extends Utilisateur {
   
   @JsonIgnore
   @OneToMany(mappedBy = "caissier")
   private List<SessionCaisse> sessions;
    
}
