package com.edugroupe.gestionstock_springboot.dao;

import com.edugroupe.gestionstock_springboot.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Integer> {
}
