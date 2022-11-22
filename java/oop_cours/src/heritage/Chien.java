package heritage;

public class Chien extends Animal{

    public Chien(String name, double weight) {
        super(name, weight);
    }

    // Méthode propre à la classe chien
    public void aboie(){
        System.out.println("J'aboie");
    }
}
