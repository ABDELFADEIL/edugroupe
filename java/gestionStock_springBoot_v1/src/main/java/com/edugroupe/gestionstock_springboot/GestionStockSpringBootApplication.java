package com.edugroupe.gestionstock_springboot;

import com.edugroupe.gestionstock_springboot.dto.UtilisateurDto;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import com.edugroupe.gestionstock_springboot.security.config.RsaKeyProperties;
import com.edugroupe.gestionstock_springboot.service.IUtilisateurService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;

@EnableConfigurationProperties(RsaKeyProperties.class)
@SpringBootApplication
public class GestionStockSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(GestionStockSpringBootApplication.class, args);
    }

    // @Autowired
    //    IUtilisateurService utilisateurService;
    @Bean
    CommandLineRunner commandLineRunner(IUtilisateurService utilisateurService) {
        return args -> {
/*
            utilisateurService.inscription(new UtilisateurDto(
                    "beel", "beel", LocalDate.now(),
                    "user", "password", "Paris","USER"
                    ));

 */

        };
    }
}
