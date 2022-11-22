package exo_2_points;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void affichePoint(){
        System.out.println("Le point (x, y) = (" + this.getX() + ", " + this.getY()+")");
    }

    public double calculDistance(Point point){
        double distance = 0;
        distance = Math.sqrt(((point.y - this.y)*2) + ((point.x - this.x)*2));
        return distance;
    }

    public Point calculCoordsMilieu(Point point1, Point point2){
        int x = point1.x + (point2.x - point1.x);
        int y = point1.x + (point2.x - point1.x);
        return new Point(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
