package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.entity.Commande;
import com.edugroupe.gestionstock_springboot.entity.Produit;
import com.edugroupe.gestionstock_springboot.service.IProduitService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProduitController {


    private final IProduitService produitService;

    public ProduitController(IProduitService produitService) {
        this.produitService = produitService;
    }


    @GetMapping( "")
    public ResponseEntity<List<Produit>> getProduits(){
        List<Produit> produits = produitService.findAll();
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
