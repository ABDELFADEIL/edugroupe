package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.ProduitRepository;
import com.edugroupe.gestionstock_springboot.entity.Produit;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProduitServiceImplService implements IProduitService {

    private final ProduitRepository produitRepository;

    public ProduitServiceImplService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public List<Produit> findAll() {
        return produitRepository.findAll();
    }

    @Override
    public Produit findById(Integer idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }
}
