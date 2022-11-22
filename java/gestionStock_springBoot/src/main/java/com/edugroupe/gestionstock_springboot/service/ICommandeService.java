package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.entity.Commande;

import java.util.List;

public interface ICommandeService {
    List<Commande> findAll();
    Commande findById(Integer idCommande);
}
