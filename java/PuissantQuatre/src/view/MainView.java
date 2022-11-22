package view;

import business.Couleur;
import business.Grille;
import business.Jeton;
import business.Position;

import java.util.Arrays;

public class MainView {

    public void display(){
        // TODO
    }
    public static void main(String[] args) {
        Grille grille = new Grille();
        System.out.println(grille);
        System.out.println("isFullColonne : " + grille.isFullColonne( 1));
        System.out.println("isFullGrille : " + grille.isFullGrille());
        grille.insererJeton(new Jeton(Couleur.ROUGE), 1); // ajout case 1
        System.out.println(grille);
        grille.insererJeton(new Jeton(Couleur.ROUGE), 1); // ajout case 2
        System.out.println(grille);
        grille.insererJeton(new Jeton(Couleur.ROUGE), 1); // ajout case 3
        System.out.println(grille);
        grille.insererJeton(new Jeton(Couleur.ROUGE), 1); // ajout case 4
        System.out.println(grille);
        grille.insererJeton(new Jeton(Couleur.ROUGE), 2); // ajout case 5
        System.out.println(grille);
        grille.insererJeton(new Jeton(Couleur.ROUGE), 5); // ajout case 6
        System.out.println(grille);
        grille.insererJeton(new Jeton(Couleur.ROUGE), 6); // ajout case 7 qui n'exist pas
        System.out.println(grille);
        grille.insererJeton(new Jeton(Couleur.ROUGE), 7); // ajout case 7 qui n'exist pas
        System.out.println(grille);
        Arrays.stream(grille.getJetons()).forEach(jetons -> {
            Arrays.stream(jetons).forEach(System.out::println);
        });
        System.out.println("isFullColonne : " + grille.isFullColonne( 1));
        System.out.println("isFullGrille : " + grille.isFullGrille());
        //System.out.println("alignementRealise : " + grille.alignementRealise(new Position(0, 2)));
        System.out.println("alignementHorizontal : " + grille.alignementHorizontal(new Position(0, 1)));
        System.out.println("alignementVertical : " + grille.alignementVertical(new Position(0, 2)));

    }
}
