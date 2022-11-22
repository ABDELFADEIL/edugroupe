package business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GrilleTest {
    /**
     * Methods under test:
     * <p>
     * <p>
     * /**
     * Method under test: {@link Grille#insererJeton(Jeton, int)}
     */
    @Test
    void testInsererJeton() {
        Grille grille = new Grille();
        int row = grille.insererJeton(new Jeton(Couleur.JAUNE), 0);
        System.out.println(row);
        assertEquals(0, grille.insererJeton(new Jeton(Couleur.JAUNE), 0));
    }

    /**
     * Method under test: {@link Grille#alignementHorizontal(Position)}
     */
    @Test
    void testAlignementHorizontal() {
        int expectedValue = 1, numColumn = 1;
        Grille grille = new Grille();
        int line = grille.insererJeton(new Jeton(Couleur.JAUNE), numColumn);
        int horizontalGridSize = grille.alignementHorizontal(new Position(0, 1));
        assertEquals(expectedValue, horizontalGridSize);
    }

    /**
     * Method under test: {@link Grille#alignementDiagonal1(Position)}
     */
    @Test
    void testAlignementDiagonal1() {
        Grille grille = new Grille();
        Jeton jeton1 = new Jeton(Couleur.JAUNE);
        Jeton jeton2 = new Jeton(Couleur.JAUNE);
        Jeton jeton3 = new Jeton(Couleur.JAUNE);
        Jeton jeton4 = new Jeton(Couleur.JAUNE);
        grille.insererJeton(jeton1, 0);
        grille.insererJeton(jeton2, 1);
        grille.insererJeton(jeton2, 1);
        grille.insererJeton(jeton3, 2);
        grille.insererJeton(jeton3, 2);
        grille.insererJeton(jeton3, 2);
        grille.insererJeton(jeton4, 3);
        grille.insererJeton(jeton4, 3);
        grille.insererJeton(jeton4, 3);
        grille.insererJeton(jeton4, 3);
        int i = grille.alignementDiagonal1(new Position(3, 3));
        System.out.println(i);
        assertEquals(4, i);
    }

    /**
     * Method under test: {@link Grille#alignementDiagonal2(Position)}
     */
    @Test
    void testAlignementDiagonal2() {
        Grille grille = new Grille();
        Jeton jeton1 = new Jeton(Couleur.ROUGE);
        Jeton jeton2 = new Jeton(Couleur.ROUGE);
        Jeton jeton3 = new Jeton(Couleur.JAUNE);
        Jeton jeton4 = new Jeton(Couleur.JAUNE);
        Jeton jeton5 = new Jeton(Couleur.JAUNE);

        // colonne 3
        grille.insererJeton(jeton1, 2);
        grille.insererJeton(jeton2, 2);
        grille.insererJeton(jeton3, 2);
        // colonne 4
        grille.insererJeton(jeton1, 3);
        grille.insererJeton(jeton2, 3);
        grille.insererJeton(jeton3, 3);
        grille.insererJeton(jeton4, 3);
        // colonne 5
        grille.insererJeton(jeton1, 4);
        grille.insererJeton(jeton2, 4);
        grille.insererJeton(jeton3, 4);
        grille.insererJeton(jeton4, 4);
        grille.insererJeton(jeton5, 4);
        // colonne 6
        grille.insererJeton(jeton1, 5);
        grille.insererJeton(jeton2, 5);
        grille.insererJeton(jeton3, 5);
        grille.insererJeton(jeton4, 5);
        grille.insererJeton(jeton5, 5);
        grille.insererJeton(jeton5, 5);


        int i = grille.alignementDiagonal1(new Position(2, 2));
        System.out.println(i);
        assertEquals(4, i);
    }


}

