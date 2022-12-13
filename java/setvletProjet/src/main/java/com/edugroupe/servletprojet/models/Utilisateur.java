package com.edugroupe.servletprojet.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Utilisateur implements Serializable {

    private Integer id;
    private String nom;
    private String prenom;
    private String adresse;
    private LocalDate dateNaissance;
    private String email;
    private String password;
    private List<Role> roles = new ArrayList<>();

    public Utilisateur() {
    }

    public Utilisateur(Integer id, String nom, String prenom, String adresse, LocalDate dateNaissance, String email, String password, List<Role> roles) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public List<Role> addRole(Role role){
        if (this.roles == null){
            this.roles = new ArrayList<>();
        }
        this.roles.add(role);
        return this.roles;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Utilisateur.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("nom='" + nom + "'")
                .add("prenom='" + prenom + "'")
                .add("adresse='" + adresse + "'")
                .add("dateNaissance=" + dateNaissance)
                .add("email='" + email + "'")
                .add("password='" + password + "'")
                .add("roles=" + roles)
                .toString();
    }
}
