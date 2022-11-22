package edugroupe.gescom.model;

import java.time.LocalDate;

public class Client {

    private int id_client;
    private String nom_client;
    private String prenom_client;
    private String adresse;
    private LocalDate ddn_client;

    public Client() {
    }


    public Client(int id_client, String nom_client, String prenom_client, String adresse, LocalDate ddn_client) {
        this.id_client = id_client;
        this.nom_client = nom_client;
        this.prenom_client = prenom_client;
        this.adresse = adresse;
        this.ddn_client = ddn_client;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public LocalDate getDdn_client() {
        return ddn_client;
    }

    public void setDdn_client(LocalDate ddn_client) {
        this.ddn_client = ddn_client;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client=" + id_client +
                ", nom_client='" + nom_client + '\'' +
                ", prenom_client='" + prenom_client + '\'' +
                ", adresse='" + adresse + '\'' +
                ", ddn_client=" + ddn_client +
                '}';
    }
}
