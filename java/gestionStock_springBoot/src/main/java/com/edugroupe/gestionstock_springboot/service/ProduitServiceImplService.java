package com.edugroupe.gestionstock_springboot.service;

import com.edugroupe.gestionstock_springboot.dao.CategorieRepository;
import com.edugroupe.gestionstock_springboot.dao.ProduitRepository;
import com.edugroupe.gestionstock_springboot.entity.Categorie;
import com.edugroupe.gestionstock_springboot.entity.Produit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProduitServiceImplService implements IProduitService {

    private final ProduitRepository produitRepository;
    private final CategorieRepository categorieRepository;

    public ProduitServiceImplService(ProduitRepository produitRepository, CategorieRepository categorieRepository) {
        this.produitRepository = produitRepository;
        this.categorieRepository = categorieRepository;
    }

    @Override
    public Page<Produit> findAll(Pageable pageable) {
        return produitRepository.findAll(pageable);
    }

    @Override
    public Produit findById(Integer idProduit) {
        return produitRepository.findById(idProduit).orElse(null);
    }

    @Override
    public Produit addProduct(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit updateProduct(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Page<Produit> findProduitsByKeyword(Pageable pageable, String keyword) {
        return produitRepository.findAllByNomContainsOrDesignationContains(pageable, keyword, keyword);
    }

    @Override
    public boolean deleteById(Integer productId) {
        if (produitRepository.existsById(productId)) {
            produitRepository.deleteById(productId);
            return true;
        }
        return false;
    }

    @Override
    public Page<Produit> findProduitsByCategorieAndKeyword(Pageable pageable, Integer categoryId, String keyword) {
        Categorie categorie = categorieRepository.findById(categoryId).orElse(null);
        if (categorie != null){
            Page<Produit> produitPage = produitRepository
                    .findByCategorieIdAndNomContainingOrDesignationContaining(
                            pageable, categorie.getId(), keyword, keyword);
            return produitPage;
        }
        return null;

    }

}
