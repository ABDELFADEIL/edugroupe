package exercice;

public class Truck extends Car{

    private int weight;

    public Truck(int speed, double regularPrice, String color) {
        super(speed, regularPrice, color);
    }

    @Override
    public double getSalePrice() {
        return weight > 2000 ? getRegularPrice() - (getRegularPrice() * 0.10) :
                getRegularPrice() - (getRegularPrice() * 0.20);
    }
}
