package LSP;

public class Rectangle {
    protected int height;
    protected int width;

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getM_height() {
        return height;
    }

    public int getM_width() {
        return width;
    }

    public void getArea(){
        System.out.println("Surface = " + width * height);
    }
}
