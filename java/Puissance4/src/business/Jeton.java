package business;

import java.io.Serializable;

public class Jeton implements Serializable {

    public Couleur couleur;

    public Jeton(Couleur couleur) {
        this.couleur = couleur;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return "|" + couleur.name();
    }

}
