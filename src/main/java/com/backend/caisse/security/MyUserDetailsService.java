package com.backend.caisse.security;

import java.util.ArrayList;
import java.util.List;

import com.backend.caisse.entities.Utilisateur;
import com.backend.caisse.service.UtilisateurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MyUserDetailsService implements UserDetailsService {
@Autowired
UtilisateurService userService;
@Override
public UserDetails loadUserByUsername(String username) throws
UsernameNotFoundException {
Utilisateur user = userService.chercherParPrenom(username);
if (user==null) 
 throw new UsernameNotFoundException("Utilisateur introuvable !");
List<GrantedAuthority> auths = new ArrayList<>();
user.getPostes().forEach(role -> {
GrantedAuthority auhority = new
SimpleGrantedAuthority(role.getPoste());
auths.add(auhority);
});
return new org.springframework.security.core.
userdetails.User(user.getPrenom(),user.getMotDePasse(),auths);
 }
    
}
