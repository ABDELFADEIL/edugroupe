package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.UserProfileUpdate;
import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUtilisateurService {
    List<Utilisateur> findAll();
    Utilisateur findById(Integer idUtilisateur);
    Utilisateur inscription(UtilisateurDto utilisateurDto);
    Utilisateur ajouterRoleAUtilisateur(String roleName, int idUtilisateur);
    Utilisateur isUtilisateurExists(String email);
    Utilisateur update(UtilisateurDto utilisateurDto);
    Page<Utilisateur> findByNomOrDesignationContains(Pageable pageable, String keyword);
    Utilisateur saveUser(Utilisateur utilisateur);
    boolean deleteUserById(Integer userId);
    Utilisateur findByEmail(String email);
    Utilisateur updateProfile(UserProfileUpdate profileUpdate, Integer utlisateurId);
}
