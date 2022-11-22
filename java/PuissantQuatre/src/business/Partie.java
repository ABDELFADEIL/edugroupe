package business;

import java.io.Serializable;
import java.util.Random;

public class Partie implements Serializable {

    private Grille grille;
    private Joueur [] joueurs;
    private Joueur joueurCourant;
    private boolean partieFinie;
    private Joueur gagnant;
    private boolean parAbandon;

    public Partie() {
        joueurs = new Joueur[]{new Joueur(Couleur.JAUNE), new Joueur(Couleur.ROUGE)};
        grille = new Grille();
        joueurCourant = joueurs[(new Random().nextInt(2))];
    }

    public Grille getGrille() {
        return grille;
    }

    public Joueur[] getJoueurs() {
        return joueurs;
    }
    public Joueur getJoueurCourant() {
        return joueurCourant;
    }


    public boolean isPartieFinie() {
        return partieFinie;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    /*
    TODO
    a revoir
     */
    public boolean isParAbandon() {
        return parAbandon;
    }

    public void setParAbandon(boolean parAbandon) {
        this.parAbandon = parAbandon;
    }

}
