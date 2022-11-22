package edugroupe.gescom.model;

public class LigneCommande {
    private int num_cmd;
    private int id_prod;
    private int quantite;

    public LigneCommande(int num_cmd, int id_prod, int quantite) {
        this.num_cmd = num_cmd;
        this.id_prod = id_prod;
        this.quantite = quantite;
    }

    public int getNum_cmd() {
        return num_cmd;
    }

    public void setNum_cmd(int num_cmd) {
        this.num_cmd = num_cmd;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
