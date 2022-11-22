package com.edugroupe.gestionstock_springboot.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "ligne_commande")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class LigneCommande implements Serializable {

    @EmbeddedId
    private CommandeProduitId id;
    //@Id
    @ManyToOne
    @MapsId("idCommande")
    //@JoinColumn(name="id_commande")
    @JsonBackReference
    private Commande commande ;
    //@Id
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idProduit")
    //@JoinColumn(name="id_produit")
    private Produit produit;
    private int quantite;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LigneCommande)) return false;
        LigneCommande that = (LigneCommande) o;
        return getQuantite() == that.getQuantite() && Objects.equals(getId(), that.getId()) && Objects.equals(getCommande(), that.getCommande()) && Objects.equals(getProduit(), that.getProduit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCommande(), getProduit(), getQuantite());
    }
}
