package com.edugroupe.gestionstock_springboot.dto;

import com.edugroupe.gestionstock_springboot.entity.Role;
import com.edugroupe.gestionstock_springboot.entity.Utilisateur;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
public class UtilisateurDto {

    private Integer id;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String email;
    private String password;
    private String adresse;
    private String roleName;

    public static Utilisateur toUtilisateur(UtilisateurDto dto){
        return new Utilisateur(
                dto.id,
                dto.nom, dto.getPrenom(),
                dto.adresse, dto.dateNaissance,
                dto.email, dto.password, Arrays.asList(new Role(null, dto.roleName)));
    }

    public static UtilisateurDto toUtilisateurDto(Utilisateur utilisateur){
        String roleName = utilisateur.getRoles().stream()
                .filter(role -> role.getRoleName().equals("ADMIN"))
                .findFirst().orElse(null).getRoleName();
        roleName = roleName.equals("ADMIN") ? "ADMIN" : "USER";
        return new UtilisateurDto(
                utilisateur.getId(),
                utilisateur.getNom(),
                utilisateur.getPrenom(), utilisateur.getDateNaissance(),
                utilisateur.getEmail(), utilisateur.getPassword(),
                utilisateur.getAdresse(), roleName);
    }


}
