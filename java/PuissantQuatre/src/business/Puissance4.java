package business;

import java.io.Serializable;

public class Puissance4 implements Serializable {

    private Partie puissance4;

    public Puissance4() {
    }

    public Puissance4(Partie puissance4) {
        this.puissance4 = puissance4;
    }

    public boolean isGameOver(){
        // TODO
        return puissance4.isPartieFinie();
    }
    public void jouer(int numColonne){
        // TODO
    }
    public void abandonner(){
        //TODO
    }
}
