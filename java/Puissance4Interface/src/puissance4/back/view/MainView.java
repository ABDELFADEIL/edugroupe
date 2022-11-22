package puissance4.back.view;


import java.util.Arrays;
import java.util.Scanner;
import puissance4.back.business.Partie;
import puissance4.back.business.Puissance4;

public class MainView {

    public void display(){
        // TODO
    }
    public static void main(String[] args) {
        Puissance4 puissance4 = new Puissance4(new Partie());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Passer le jeton numéro comprit entre 0 et 5");
        int numCol;
        while (!puissance4.isGameOver()) {
            System.out.println(puissance4.getPuissance4().getGrille());
            System.out.println("Passer le jeton numéro comprit entre 0 et 5. \n le Joueur : "
                    + puissance4.getPuissance4().getJoueurCourant());
             numCol = scanner.nextInt();
            puissance4.jouer(numCol);
            System.out.println(puissance4.getPuissance4().getGrille());
            System.out.println(puissance4.getPuissance4().getGagnant() + " est GAGNE !");
        }
    }
}
