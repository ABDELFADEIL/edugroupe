package com.edugroupe.gestionstock_springboot;

import com.edugroupe.gestionstock_springboot.dao.CommandeRepository;
import com.edugroupe.gestionstock_springboot.dao.RoleRepository;
import com.edugroupe.gestionstock_springboot.dao.UtilisateurRepository;
import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Commande;
import com.edugroupe.gestionstock_springboot.entity.Role;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import com.edugroupe.gestionstock_springboot.service.IUtilisateurService;
import com.edugroupe.gestionstock_springboot.service.UtilisateurServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.List;

//@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class GestionStockApplication implements CommandLineRunner {

    @Autowired
    private CommandeRepository commandeRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UtilisateurRepository utilisateurRepository;



    public static void main(String[] args) {
        SpringApplication.run(GestionStockApplication.class, args);
    }

    @Autowired
    IUtilisateurService utilisateurService;

    @Override
    public void run(String... args) throws Exception {

        /*
        List<Commande> commandes = commandeRepository.findAll();
        commandes.forEach(commande -> {
            System.out.println(commande);
        });

        Role role = roleRepository.findById(2).orElse(null);
        System.out.println("role : " + role.getId() + " : " + role.getRoleName());
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        utilisateurs.forEach(utilisateur -> {
            utilisateur.getRoles().add(role);
            utilisateurRepository.save(utilisateur);
        });

         */
    }
}
