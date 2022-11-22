package abstraction;

public abstract class Animal {

    public String name;
    public double weight;

    public void run(){
        System.out.println("Je cours");
    }
    public abstract void son();
}
