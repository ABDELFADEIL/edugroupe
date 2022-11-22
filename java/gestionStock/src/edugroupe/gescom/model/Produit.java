package edugroupe.gescom.model;

public class Produit {

    private int id_prod;
    private String nom_prod;
    private String designation_prod;
    private double prix_prod;
    private int stock;

    public Produit() {
    }

    public Produit(String nom_prod, String designation_prod, double prix_prod, int stock) {
        this.nom_prod = nom_prod;
        this.designation_prod = designation_prod;
        this.prix_prod = prix_prod;
        this.stock = stock;
    }

    public int getId_prod() {
        return id_prod;
    }

    public void setId_prod(int id_prod) {
        this.id_prod = id_prod;
    }

    public String getNom_prod() {
        return nom_prod;
    }

    public void setNom_prod(String nom_prod) {
        this.nom_prod = nom_prod;
    }

    public String getDesignation_prod() {
        return designation_prod;
    }

    public void setDesignation_prod(String designation_prod) {
        this.designation_prod = designation_prod;
    }

    public double getPrix_prod() {
        return prix_prod;
    }

    public void setPrix_prod(double prix_prod) {
        this.prix_prod = prix_prod;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
