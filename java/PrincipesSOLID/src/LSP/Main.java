package LSP;

public class Main {

    private static Rectangle getNewRectangle(){
        return new Square();
    }

    public static void main(String[] args) {
        Rectangle r = getNewRectangle();
        r.setWidth(5);
        r.setHeight(10);
        r.getArea();

    }
}
