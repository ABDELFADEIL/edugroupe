package com.edugroupe.gestionstock_springboot.controller;


import com.edugroupe.gestionstock_springboot.dto.AuthResponseDTO;
import com.edugroupe.gestionstock_springboot.dto.LoginDto;
import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import com.edugroupe.gestionstock_springboot.security.JWTGenerator;
import com.edugroupe.gestionstock_springboot.service.IUtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private IUtilisateurService utilisateurService;
    private PasswordEncoder passwordEncoder;
    private JWTGenerator jwtGenerator;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, IUtilisateurService utilisateurService,
                          PasswordEncoder passwordEncoder, JWTGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.utilisateurService = utilisateurService;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping(value = "login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDto loginDto){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                loginDto.getEmail(),
                loginDto.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        System.out.println(token);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }


    @PostMapping(value = "register")
    public ResponseEntity<Utilisateur> register(@RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur =
                utilisateurService.isUtilisateurExists(utilisateurDto.getEmail());
        if (utilisateur != null) {
            throw new RuntimeException("Utilisateur déjà existe");
        }
        utilisateur = utilisateurService.inscription(utilisateurDto);
        return new ResponseEntity<>(utilisateur, HttpStatus.CREATED);
    }

    @PutMapping(value = "update")
    public ResponseEntity<Utilisateur> updateUser(@RequestBody UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur = utilisateurService.update(utilisateurDto);
        return new ResponseEntity<>(utilisateur, HttpStatus.OK);
    }
    /*get current user */
    @GetMapping("current-user")
    public ResponseEntity<Utilisateur> getCurrentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Utilisateur utilisateur = utilisateurService.isUtilisateurExists(auth.getName());
        if (utilisateur == null) {
            return new ResponseEntity<>(null, HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        }
        return ResponseEntity.ok(utilisateur);
    }
}
