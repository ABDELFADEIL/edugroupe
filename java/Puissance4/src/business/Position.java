package business;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {

    private int ligne;
    private int colonne;

    public Position(int abs, int ord) {
        this.ligne = abs;
        this.colonne = ord;
    }

    public int getAbs() {
        return ligne;
    }

    public int getOrd() {
        return colonne;
    }

    @Override
    public String toString() {
        return "Position{" +
                "ligne=" + ligne +
                ", colonne=" + colonne +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position position = (Position) o;
        return this.getAbs() == position.getAbs() && this.getOrd() == position.getOrd();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getAbs(), this.getOrd());
    }
}
