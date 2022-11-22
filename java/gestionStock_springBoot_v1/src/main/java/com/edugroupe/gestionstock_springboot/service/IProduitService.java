package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.entity.Produit;

import java.util.List;

public interface IProduitService {

    List<Produit> findAll();
    Produit findById(Integer idProduit);
}
