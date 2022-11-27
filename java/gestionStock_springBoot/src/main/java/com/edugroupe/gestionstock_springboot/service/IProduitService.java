package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProduitService {

    Page<Produit> findAll(Pageable pageable);
    Produit findById(Integer idProduit);
}
