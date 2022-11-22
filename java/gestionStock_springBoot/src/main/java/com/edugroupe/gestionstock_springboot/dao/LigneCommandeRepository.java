package com.edugroupe.gestionstock_springboot.dao;

import com.edugroupe.gestionstock_springboot.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LigneCommandeRepository extends JpaRepository<LigneCommande, Integer> {

    List<LigneCommande> findAllByCommande_Id(int idCommande);
}
