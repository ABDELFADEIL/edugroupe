package design_pattern.factory;

public class Rectangle implements Shape{
    @Override
    public void draw() {
        System.out.println("J'ai tracé un rectangle");
    }
}
