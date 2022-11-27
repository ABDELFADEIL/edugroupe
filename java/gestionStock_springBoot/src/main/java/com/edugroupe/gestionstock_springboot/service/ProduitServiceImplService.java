package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.ProduitRepository;
import com.edugroupe.gestionstock_springboot.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImplService implements IProduitService {

    private final ProduitRepository produitRepository;

    public ProduitServiceImplService(ProduitRepository produitRepository) {
        this.produitRepository = produitRepository;
    }

    @Override
    public Page<Produit> findAll(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    @Override
    public Produit findById(Integer idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }

}
