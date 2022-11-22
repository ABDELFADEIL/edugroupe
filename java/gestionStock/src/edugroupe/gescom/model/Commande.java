package edugroupe.gescom.model;

import java.time.LocalDate;
import java.util.Date;

public class Commande {

    private int num_cmd;
    private LocalDate date_cmd;
    private int num_client;

    public Commande() {
    }

    public Commande(LocalDate date_cmd, int num_client) {
        this.date_cmd = date_cmd;
        this.num_client = num_client;
    }

    public Commande(int num_cmd, LocalDate date_cmd, int num_client) {
        this.num_cmd = num_cmd;
        this.date_cmd = date_cmd;
        this.num_client = num_client;
    }

    public int getNum_cmd() {
        return num_cmd;
    }

    public void setNum_cmd(int num_cmd) {
        this.num_cmd = num_cmd;
    }

    public LocalDate getDate_cmd() {
        return date_cmd;
    }

    public void setDate_cmd(LocalDate date_cmd) {
        this.date_cmd = date_cmd;
    }

    public int getNum_client() {
        return num_client;
    }

    public void setNum_client(int num_client) {
        this.num_client = num_client;
    }
}
