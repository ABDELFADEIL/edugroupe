package com.edugroupe.gestionstock_springboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "commande")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Commande implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "date_commande")
    private LocalDate dateCommande;
    @OneToMany(mappedBy = "commande", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<LigneCommande> ligneCommandeList = new ArrayList<>();
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_utilisateur", nullable = false, updatable = false, insertable = false)
    private Utilisateur utilisateur;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Commande)) return false;
        Commande commande = (Commande) o;
        return getUtilisateur() == commande.getUtilisateur() && Objects.equals(getId(), commande.getId()) && Objects.equals(getDateCommande(), commande.getDateCommande()) && Objects.equals(getLigneCommandeList(), commande.getLigneCommandeList()) && Objects.equals(getUtilisateur(), commande.getUtilisateur());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateCommande(), getUtilisateur(), getLigneCommandeList(), getUtilisateur());
    }
}
