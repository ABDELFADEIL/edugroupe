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
        Position position = null;
        outer: for (int i = 0; i < plateauJetons.length; i++) {
            for (int j = 0; j < plateauJetons[i].length; j++) {
                if(j == numColonne && plateauJetons[i] [j] == null){
                    plateauJetons[i] [j] = jeton;
                    ligne = i;
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
        Couleur couleur = plateauJetons[position.getAbs()][position.getOrd()].getCouleur();
        int ligne = position.getAbs();
        int colonne = position.getOrd();
        int parcourirColone = colonne + 1;
        boolean done = false;
        while (!done){
            Jeton jeton = null;
            if (parcourirColone < NB_COLONNES && parcourirColone >= 0){
                jeton = plateauJetons[ligne][parcourirColone];
            }
            Couleur couleurAVerifier = null;
            if (jeton != null){
                couleurAVerifier = jeton.couleur;
            }
            if(parcourirColone >= colonne && (couleurAVerifier == null || couleur != couleurAVerifier)){
                nbAlligne = 1;
                parcourirColone = colonne - 1;
            } else if (parcourirColone < colonne && (couleurAVerifier == null || couleur != couleurAVerifier)) {
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
        System.out.println("alignementHorizontal : " + nbAlligne);
        return nbAlligne;
    }
    public int alignementVertical(Position position){
        int nbAlligne = 1;
        Couleur couleur = plateauJetons[position.getAbs()][position.getOrd()].couleur;
        int ligne = position.getAbs();
        int colonne = position.getOrd();
        int parcourirLigne = ligne - 1;
        boolean memeCouleur = true;
        // commence par haut
        while (parcourirLigne >= 0 && memeCouleur){
            Jeton jeton = plateauJetons[parcourirLigne][colonne];
            if (jeton != null ){
                if (Objects.equals(couleur, jeton.couleur)){
                    parcourirLigne--;
                    nbAlligne++;
                }else {
                    memeCouleur = false;
                }
            }else {
                memeCouleur = false;
            }
        }

        parcourirLigne = position.getAbs() + 1;
        // continue ver le bas
        while (parcourirLigne < Config.NB_LIGNES && memeCouleur){
            Jeton jeton = plateauJetons[parcourirLigne][colonne];
            if (jeton != null){
                if (Objects.equals(couleur, jeton.getCouleur())){
                    parcourirLigne++;
                    nbAlligne++;
                }else {
                    memeCouleur = false;
                }
            }else {
                memeCouleur = false;
            }
        }
        return nbAlligne;
    }
    public int alignementDiagonal1(Position position){
        //1-	Déclartion des variables
        Couleur couleurDuJetonInsere;
        int ligne,colonne, compteurDeJetonDeMemeCouleur;
        boolean memeCouleur;
        //2-	Initialisation
        couleurDuJetonInsere = this.plateauJetons[position.getAbs()][position.getOrd()].getCouleur();
        ligne = position.getAbs() - 1;
        colonne = position.getOrd()-1;
        compteurDeJetonDeMemeCouleur = 1;
        memeCouleur = true;
        //3-	Regardons à la gauche du jeton inséré
        while(ligne >= 0 && colonne >=0  && memeCouleur) {
            if(this.plateauJetons[ligne][colonne] != null &&
                    this.plateauJetons[ligne][colonne].getCouleur() == couleurDuJetonInsere)  {
                compteurDeJetonDeMemeCouleur++;
                colonne--;
                ligne--;
            }else {
                memeCouleur = false;
            }
            //}else {
            //	memeCouleur = false;
            //}
        }
        //4-	Regardons à la droite du jeton à partir du jeton inséré
        ligne = position.getAbs() + 1;
        colonne = position.getOrd()+1;
        memeCouleur = true;

        while(ligne < NB_LIGNES && colonne < NB_COLONNES  && memeCouleur) {
            if(this.plateauJetons[ligne][colonne] != null &&
                    this.plateauJetons[ligne][colonne].getCouleur() == couleurDuJetonInsere)  {
                compteurDeJetonDeMemeCouleur++;
                colonne++;
                ligne++;
            }else {
                memeCouleur = false;
            }
        }
        System.out.println("alignementDiagonal1 : " + compteurDeJetonDeMemeCouleur);
        return compteurDeJetonDeMemeCouleur;
    }
    public int alignementDiagonal2(Position position){
        //1-	Déclartion des variables
        Couleur couleurDuJetonInsere;
        int ligne,colonne, compteurDeJetonDeMemeCouleur;
        boolean memeCouleur;
        //2-	Initialisation
        couleurDuJetonInsere = this.plateauJetons[position.getAbs()][position.getOrd()].getCouleur();
        ligne = position.getAbs() + 1;
        colonne = position.getOrd() - 1;
        compteurDeJetonDeMemeCouleur = 1;
        memeCouleur = true;
        //3-	Regardons à la gauche du jeton inséré
        while(ligne >= 0 && colonne >=0 && ligne < Config.NB_LIGNES && colonne < Config.NB_COLONNES  && memeCouleur) {
            if(this.plateauJetons[ligne][colonne] != null &&
                    this.plateauJetons[ligne][colonne].getCouleur() == couleurDuJetonInsere)  {
                compteurDeJetonDeMemeCouleur++;
                colonne--;
                ligne++;
            }else {
                memeCouleur = false;
            }
            //}else {
            //	memeCouleur = false;
            //}
        }
        //4-	Regardons à la droite du jeton à partir du jeton inséré
        ligne = position.getAbs() - 1;
        colonne = position.getOrd() + 1;
        memeCouleur = true;

        while(ligne < NB_LIGNES && ligne >= 0 && colonne < NB_COLONNES && colonne >= 0  && memeCouleur) {
            if(this.plateauJetons[ligne][colonne] != null &&
                    this.plateauJetons[ligne][colonne].getCouleur() == couleurDuJetonInsere)  {
                compteurDeJetonDeMemeCouleur++;
                colonne++;
                ligne--;
            }else {
                memeCouleur = false;
            }
        }
        System.out.println("alignementDiagonal2 : " + compteurDeJetonDeMemeCouleur);
        return compteurDeJetonDeMemeCouleur;
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
