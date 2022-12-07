package com.edugroupe.gestionstock_springboot.controller;

import com.edugroupe.gestionstock_springboot.dao.UserProfileUpdate;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import com.edugroupe.gestionstock_springboot.security.JWTGenerator;
import com.edugroupe.gestionstock_springboot.service.IUtilisateurService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/utilisateurs")
public class UtilisateurController {

    private final IUtilisateurService utilisateurService;
    private final JWTGenerator jwtGenerator;
    public UtilisateurController(IUtilisateurService utilisateurService, JWTGenerator jwtGenerator) {
        this.utilisateurService = utilisateurService;
        this.jwtGenerator = jwtGenerator;
    }


    @GetMapping("")
    public ResponseEntity<Page<Utilisateur>> getUtilisateurs(
            @RequestParam(defaultValue = "0", required = false) int page,
            @RequestParam(defaultValue = "1000", required = false) int size,
            @RequestParam(defaultValue = "", required = false) String keyword
    ) {
        Page<Utilisateur> utilisateurs = utilisateurService
                .findByNomOrDesignationContains(PageRequest.of(page, size), keyword);
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

    @PostMapping("/add-update")
    public ResponseEntity<Utilisateur> getInscriptionUtilisateur(@RequestBody Utilisateur utilisateur) {
        Utilisateur utilisateur1 = utilisateurService.saveUser(utilisateur);
        if (utilisateur1 == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(utilisateur1);
    }

    @PostMapping("/update-profile")
    public ResponseEntity<Utilisateur> getUtilisateurProfile(@RequestBody UserProfileUpdate profileUpdate,
                                                             @RequestHeader("Authorization") String jwtToken) {
        Integer userId = jwtGenerator.getIdFromJWT(jwtToken);
        Utilisateur utilisateur1 = utilisateurService.updateProfile(profileUpdate, userId);
        if (utilisateur1 == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(utilisateur1);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable(name = "userId") Integer userId) {
        boolean deleted = utilisateurService.deleteUserById(userId);
        return ResponseEntity.ok(deleted);
    }


}
