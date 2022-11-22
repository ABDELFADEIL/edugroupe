package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;

import java.util.List;

public interface IUtilisateurService {
    List<Utilisateur> findAll();
    Utilisateur findById(Integer idUtilisateur);
    Utilisateur inscription(UtilisateurDto utilisateurDto);
    Utilisateur ajouterRoleAUtilisateur(String roleName, int idUtilisateur);
}
