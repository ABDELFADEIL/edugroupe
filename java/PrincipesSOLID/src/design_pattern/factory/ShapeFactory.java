package design_pattern.factory;

public class ShapeFactory {

    enum ShapeType{
        RECTANGLE, CIRCLE, SQUARE
    }
    public Shape getShape(String shapeType){
        Shape shape = null;
        if(ShapeType.CIRCLE.equals(ShapeType.valueOf(shapeType))){
            shape = new Circle();
        }else if(ShapeType.SQUARE.equals(ShapeType.valueOf(shapeType))){
            shape = new Square();
        }else if(ShapeType.RECTANGLE.equals(ShapeType.valueOf(shapeType))){
            shape = new Rectangle();
        }
        return shape;
    }
}
