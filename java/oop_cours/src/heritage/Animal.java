package heritage;

public class Animal {

    public String name;
    public double weight;

    public Animal(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    public void run(){
        System.out.println("Je cours");
    }

}
