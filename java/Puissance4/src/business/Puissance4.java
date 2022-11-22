package business;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class Puissance4 implements Serializable {

    private Partie puissance4;

    public Puissance4() {
    }

    public Puissance4(Partie puissance4) {
        this.puissance4 = puissance4;
    }

    public boolean isGameOver(){
        return puissance4.isPartieFinie();
    }
    public void jouer(int numColonne){
        Joueur joueur = puissance4.getJoueurCourant();
        Couleur couleur = joueur.getNom();
        Jeton jeton = new Jeton(couleur);
        int ligne = puissance4.getGrille().insererJeton(jeton, numColonne);
        boolean alignementRealise = puissance4.getGrille().alignementRealise(new Position(ligne, numColonne));
        System.out.println("alignementRealise : " + alignementRealise);
        if (alignementRealise){
            puissance4.setGagnant(joueur);

        }else {
            if (Objects.equals(this.puissance4.getJoueurs()[0].getNom(), joueur.getNom())){
              this.puissance4.setJoueurCourant(this.puissance4.getJoueurs()[1]);
            }else {
                this.puissance4.setJoueurCourant(this.puissance4.getJoueurs()[0]);
            }
        }

    }
    public void abandonner(){
        puissance4.setParAbandon(true);
        Joueur joueurGagnan = Arrays.stream(puissance4.getJoueurs())
                .filter(joueur -> joueur != puissance4.getJoueurCourant()).findAny().get();
        puissance4.setGagnant(joueurGagnan);
    }

    public Partie getPuissance4() {
        return puissance4;
    }
}
