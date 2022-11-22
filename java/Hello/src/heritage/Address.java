package heritage;

import heritage.Person;

public class Address extends Person {

    private String rue;
    private String numero;
    private int code;
    private String ville;

    public Address() {
    }

    public Address(String rue, String numero, int code, String ville) {
        this.rue = rue;
        this.numero = numero;
        this.code = code;
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }
}
