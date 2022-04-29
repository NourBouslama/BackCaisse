package com.backend.caisse;

import javax.annotation.PostConstruct;

import com.backend.caisse.entities.Caissier;
import com.backend.caisse.entities.Utilisateur;
import com.backend.caisse.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class CaisseApplication {
	@Autowired
	UtilisateurService userService;
	public static void main(String[] args) {
		SpringApplication.run(CaisseApplication.class, args);
	}

	/*@PostConstruct
void init_users() {
//ajouter les rôles
Caissier c=new Caissier();
//ajouter les users
userService.AjouterUtilisateur(new Utilisateur(null,"mat7","bouslama","hamouda","hamouda@gmail.com","tunis","","123",null));
userService.AjouterUtilisateur(new Utilisateur(null,"mat8","ben noureddine","manar","manar@gmail.com","menzel tmim","","123",null));

//ajouter les rôles aux users
userService.AjouterPosteaUtilisateur("hamouda", "super caissier");
userService.AjouterPosteaUtilisateur("manar", "caissier");

}*/

	@Bean
	BCryptPasswordEncoder getBCE() {
	return new BCryptPasswordEncoder();
}


}
