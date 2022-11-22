package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.entity.LigneCommande;

import java.util.List;

public interface ILigneCommandeService {

    List<LigneCommande> findAll();
    LigneCommande findById(Integer idLigneCommande);

    List<LigneCommande> findByIdCommande(Integer idCommande);
}
