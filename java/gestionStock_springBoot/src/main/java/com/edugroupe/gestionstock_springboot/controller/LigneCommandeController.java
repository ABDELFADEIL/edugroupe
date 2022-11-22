package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.entity.LigneCommande;
import com.edugroupe.gestionstock_springboot.service.ILigneCommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligneCommandes")
public class LigneCommandeController {

    private final ILigneCommandeService ligneCommandeService;

    public LigneCommandeController(ILigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }


    @GetMapping( "")
    public ResponseEntity<List<LigneCommande>> getAllLigneCommandes(){
        List<LigneCommande> ligneCommandes = ligneCommandeService.findAll();
        if(ligneCommandes == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ligneCommandes);
    }

    @GetMapping( "/{idLigneCommande}")
    public ResponseEntity<LigneCommande> getLigneCommandeById(@PathVariable Integer idLigneCommande){
        LigneCommande ligneCommande = ligneCommandeService.findById(idLigneCommande);
        if(ligneCommande == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ligneCommande);
    }

    @GetMapping( "/commande/{idCommande}")
    public ResponseEntity<List<LigneCommande>> getLigneCommandeByCommandeId(@PathVariable int idCommande){
        List<LigneCommande> ligneCommandes = ligneCommandeService.findByIdCommande(idCommande);
        if(ligneCommandes == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(ligneCommandes);
    }

}
