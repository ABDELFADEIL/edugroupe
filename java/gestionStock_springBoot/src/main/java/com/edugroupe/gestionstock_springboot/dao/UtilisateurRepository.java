package com.edugroupe.gestionstock_springboot.dao;

import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findByEmail(String email);
    Page<Utilisateur> findByNomContainsOrPrenomContains(Pageable pageable,String nom, String prenom);
}
