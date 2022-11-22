package exo_2_points;

public class Main {
    public static void main(String[] args) {
        Point a = new Point(1, 2);
        Point b = new Point(4,5);
        a.affichePoint();
        b.affichePoint();
        double distance = a.calculDistance(b);
        System.out.println("La distance entre point a et b = " + distance);
        Point point = a.calculCoordsMilieu(a, b);
        System.out.println("Coordonnées du milieu sont sont = " + point);
    }
}
