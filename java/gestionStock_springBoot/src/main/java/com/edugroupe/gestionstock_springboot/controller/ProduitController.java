package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.entity.Categorie;
import com.edugroupe.gestionstock_springboot.entity.Commande;
import com.edugroupe.gestionstock_springboot.entity.Produit;
import com.edugroupe.gestionstock_springboot.service.IProduitService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
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
            @RequestParam(defaultValue = "1000") int size,
            @RequestParam(defaultValue = "") String keyword
    ){
        Page<Produit> produits = produitService
                .findProduitsByKeyword(PageRequest.of(page, size), keyword);
        if(produits == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produits);
    }

    @GetMapping( "/category")
    public ResponseEntity<Page<Produit>> getProduitsByCategorie(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "1000") int size,
            @RequestParam(defaultValue = "") String keyword,
            @RequestParam(required = false) Integer categoryId
    ){
        Page<Produit> produits = produitService
                .findProduitsByCategorieAndKeyword(PageRequest.of(page, size), categoryId, keyword);
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

    @PostMapping( value = "", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produit> addProduct(@RequestBody Produit produit){
        Produit produit1 = produitService.addProduct(produit);
        if(produit1 == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produit1);
    }
    @PutMapping( "")
    public ResponseEntity<Produit> updateProduct(@RequestBody Produit produit){
        Produit produit1 = produitService.updateProduct(produit);
        if(produit1 == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(produit1);
    }

    @DeleteMapping("/{productId}")
    public boolean removeProductById(@PathVariable(name = "productId") Integer productId){
        return produitService.deleteById(productId);
    }

}
