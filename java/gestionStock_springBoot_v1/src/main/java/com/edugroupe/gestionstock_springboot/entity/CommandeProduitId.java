package com.edugroupe.gestionstock_springboot.entity;

import lombok.*;

import java.io.Serializable;
import java.util.Objects;

//@Embedded
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class CommandeProduitId implements Serializable {

    private Integer idCommande;
    private Integer idProduit;

    @Override
    public String toString() {
        return "CommandeProduitId{" +
                "idCommande=" + idCommande +
                ", idProduit=" + idProduit +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CommandeProduitId)) return false;
        CommandeProduitId that = (CommandeProduitId) o;
        return Objects.equals(getIdCommande(), that.getIdCommande()) && Objects.equals(getIdProduit(), that.getIdProduit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCommande(), getIdProduit());
    }
}
