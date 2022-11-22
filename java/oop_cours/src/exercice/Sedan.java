package exercice;

public class Sedan extends Car{

    private int length;

    public Sedan(int speed, double regularPrice, String color, int length) {
        super(speed, regularPrice, color);
        this.length = length;
    }

    @Override
    public double getSalePrice() {
        return length > 20 ? getRegularPrice() - (getRegularPrice() * 0.05) :
                getRegularPrice() - (getRegularPrice() * 0.10);
    }

    public int getLength() {
        return length;
    }
    
    public void setLength(int length) {
        this.length = length;
    }
}
