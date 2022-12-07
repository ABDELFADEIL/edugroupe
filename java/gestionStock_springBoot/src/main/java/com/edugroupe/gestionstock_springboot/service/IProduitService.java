package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface IProduitService {

    Page<Produit> findAll(Pageable pageable);
    Produit findById(Integer idProduit);
    Produit addProduct(Produit produit);
    Produit updateProduct(Produit produit);
    Page<Produit> findProduitsByKeyword(Pageable pageable, String keyword);
    boolean deleteById(Integer productId);
    Page<Produit> findProduitsByCategorieAndKeyword(Pageable pageable, Integer categoryId, String keyword);
}
