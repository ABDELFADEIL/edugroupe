package puissance4.back.business;

import java.io.Serializable;

public class Joueur implements Serializable {

    private Couleur nom;

    public Joueur(Couleur nom) {
        this.nom = nom;
    }

    public Couleur getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "Joueur{" + "nom=" + nom + '}';
    }
}
