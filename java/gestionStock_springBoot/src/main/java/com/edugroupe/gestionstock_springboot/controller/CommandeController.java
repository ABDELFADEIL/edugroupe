package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.entity.Commande;
import com.edugroupe.gestionstock_springboot.service.ICommandeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final ICommandeService commandeService;

    public CommandeController(ICommandeService commandeService) {
        this.commandeService = commandeService;
    }


    @GetMapping( "")
    public ResponseEntity<List<Commande>> getClients(){
        List<Commande> commandes = commandeService.findAll();
        if(commandes== null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(commandes);
    }


    @GetMapping( "/{idCommande}")
    public ResponseEntity<Commande> getClientByIdClient(@PathVariable int idCommande){
        Commande commande = commandeService.findById(idCommande);
        if(commande== null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(commande);
    }

    /*


     */
}
