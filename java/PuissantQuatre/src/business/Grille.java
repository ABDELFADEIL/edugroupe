package business;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class Grille implements Serializable {
    public static final int NB_LIGNES = Config.NB_LIGNES;
    public static final int NB_COLONNES = Config.NB_COLONNES;
    private Jeton [][] plateauJetons;

    public Grille() {
        this.plateauJetons = new Jeton[NB_LIGNES][NB_COLONNES];
    }
    public Grille(Jeton[][] plateauJetons) {
        this.plateauJetons = plateauJetons;
    }

    public Jeton[][] getJetons() {
        return plateauJetons;
    }
    public int insererJeton(Jeton jeton, int numColonne){
        int ligne = -1;
        outer: for (int i = 0; i < plateauJetons.length; i++) {
            for (int j = 0; j < plateauJetons[i].length; j++) {
                if(j == numColonne && plateauJetons[i] [j] == null){
                    plateauJetons[i] [j] = jeton;
                    ligne = j;
                    break outer;
                }
            }
        }
        return ligne;
    }
    public boolean isFullColonne(int numColonne){
        boolean full = true;
        int index = 0;
        while (index < Config.NB_LIGNES){
            Jeton jeton = plateauJetons[index][numColonne];
            if (jeton == null){
                full = false;
                break;
            }
            index++;
        }
        return full;
    }
    public boolean isFullGrille(){
        AtomicBoolean full = new AtomicBoolean(true);
        outer: for (int i = 0; i < plateauJetons.length; i++) {
            for (int j = 0; j < plateauJetons[i].length; j++) {
                Jeton jeton = plateauJetons[i][j];
                if (jeton == null){
                    full.set(false);
                    break outer;
                }
            }
        }
        /*
        Arrays.stream(plateauJetons).forEach(jetons -> {
            full.set(!(Arrays.stream(jetons).anyMatch(Objects::isNull)));});
         */
        return full.get();
    }
    public boolean alignementRealise(Position position){
        return alignementHorizontal(position) == 4
                || alignementVertical(position) == 4
                || alignementDiagonal1(position) == 4
                || alignementDiagonal2(position) == 4;
    }
    public int alignementHorizontal(Position position){
        int nbAlligne = 1;
        Couleur couleur = plateauJetons[position.getAbs()][position.getOrd()].couleur;
        int ligne = position.getAbs();
        int colonne = position.getOrd();
        int parcourirColone = colonne + 1;
        boolean done = false;
        while (!done){
            Jeton jeton = null;
            if (parcourirColone < plateauJetons[ligne].length && parcourirColone >= 0){
                jeton = plateauJetons[ligne][parcourirColone];
            }
            Couleur couleurAVerifier = null;
            if (jeton != null){
                couleurAVerifier = jeton.couleur;
            }
            if(parcourirColone >= colonne && couleurAVerifier == null){
                nbAlligne = 1;
                parcourirColone = colonne - 1;
            } else if (parcourirColone < colonne && couleurAVerifier == null) {
                nbAlligne = 1;
                done = true;
                // cas ou il y a des couleur
            } else if (couleur.equals(couleurAVerifier)) {
                if (parcourirColone >= colonne && nbAlligne <= 4){
                    nbAlligne++;
                    parcourirColone++;
                } else if (parcourirColone < colonne && nbAlligne <= 4) {
                    nbAlligne++;
                    parcourirColone--;
                }
            }
            if (nbAlligne == 4 || parcourirColone == (colonne - 3)){
                done = true;
            }
        }
        return nbAlligne;
    }
    public int alignementVertical(Position position){
        int nbAlligne = 1;
        Couleur couleur = plateauJetons[position.getAbs()][position.getOrd()].couleur;
        int ligne = position.getAbs();
        int colonne = position.getOrd();
        int parcourirLigne = ligne + 1;
        boolean done = false;
        while (!done) {
            Jeton jeton = null;
            if (parcourirLigne < plateauJetons[ligne].length && parcourirLigne > 0) {
                jeton = plateauJetons[parcourirLigne][colonne];
            }
            Couleur couleurAVerifier = null;
            if (jeton != null) {
                couleurAVerifier = jeton.couleur;
            }
            if (parcourirLigne >= ligne && couleurAVerifier == null) {
                nbAlligne = 1;
                parcourirLigne = colonne - 1;
            } else if (parcourirLigne < ligne && couleurAVerifier == null) {
                nbAlligne = 1;
                done = true;
                // cas ou il y a des couleur
            } else if (couleur.equals(couleurAVerifier)) {
                if (parcourirLigne >= ligne && nbAlligne <= 4) {
                    nbAlligne++;
                    parcourirLigne++;
                } else if (parcourirLigne < ligne && nbAlligne <= 4) {
                    nbAlligne++;
                    parcourirLigne--;
                }
            }
            if (nbAlligne == 4 || parcourirLigne == (ligne - 3)) {
                done = true;
            }
        }
        return nbAlligne;
    }
    private int alignementDiagonal1(Position position){
        // TODO
        return 0;
    }
    private int alignementDiagonal2(Position position){
        // TODO
        return 0;
    }

    @Override
    public String toString() {
        AtomicReference<String> ch = new AtomicReference<>("");
        Arrays.stream(plateauJetons).forEach(ligne -> {
            Arrays.stream(ligne).forEach(l -> {
                if (l == null){
                    ch.updateAndGet(v -> v + "|     ");
                }else {
                    ch.updateAndGet(v -> v + l);
                }
            });
            ch.updateAndGet(v -> v + "|\n");
        });
        return ch.get();
    }

}
