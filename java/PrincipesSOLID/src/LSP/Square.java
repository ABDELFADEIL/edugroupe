package LSP;

public class Square extends Rectangle{

    @Override
    public void setHeight(int height) {
        super.height = height;
        super.width = height;
    }

    @Override
    public void setWidth(int width) {
        super.height = height;
        super.width = width;
    }
}
