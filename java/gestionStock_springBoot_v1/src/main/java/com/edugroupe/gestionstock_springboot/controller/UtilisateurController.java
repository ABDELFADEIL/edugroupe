package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import com.edugroupe.gestionstock_springboot.service.IUtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final IUtilisateurService utilisateurService;

    public UtilisateurController(IUtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }


    @GetMapping("")
    public ResponseEntity<List<Utilisateur>> getUtilisateurs() {
        List<Utilisateur> utilisateurs = utilisateurService.findAll();
        if (utilisateurs == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(utilisateurs);
    }

    @GetMapping("/{idUtilisateur}")
    public ResponseEntity<Utilisateur> getClientByIdClient(@PathVariable int idUtilisateur) {
        Utilisateur utilisateur = utilisateurService.findById(idUtilisateur);
        if (utilisateur == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(utilisateur);
    }


    @PostMapping("/inscription")
    public ResponseEntity<Utilisateur> getInscriptionUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurService.inscription(utilisateurDto);
        if (utilisateur == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(utilisateur);
    }
}
