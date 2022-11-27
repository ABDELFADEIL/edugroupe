package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.entity.Commande;
import com.edugroupe.gestionstock_springboot.entity.Produit;
import com.edugroupe.gestionstock_springboot.service.IProduitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {


    private final IProduitService produitService;

    public ProduitController(IProduitService produitService) {
        this.produitService = produitService;
    }


    @GetMapping( "")
    public ResponseEntity<Page<Produit>> getProduits(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1000000") int size
    ){
        Page<Produit> produits = produitService.findAll(PageRequest.of(page, size));
        if(produits == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produits);
    }

    @GetMapping( "/{idProduit}")
    public ResponseEntity<Produit> getClientByIdClient(@PathVariable Integer idProduit){
        Produit produit = produitService.findById(idProduit);
        if(produit == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produit);
    }

}
