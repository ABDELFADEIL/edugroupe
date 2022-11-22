package design_pattern.factory;

public class Main {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Circle circle = (Circle) shapeFactory.getShape("CIRCLE");
        Rectangle rectangle = (Rectangle) shapeFactory.getShape("RECTANGLE");
        Square square = (Square) shapeFactory.getShape("SQUARE");
        circle.draw();
        rectangle.draw();
        square.draw();
    }
}
