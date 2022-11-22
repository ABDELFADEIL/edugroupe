package design_pattern.singleton;

public class Singleton2 {

    private static Singleton2 instance = new Singleton2();
    private static int nb = 0;
    private Singleton2() {
        System.out.println("Je suis l'instance n° " + ++nb);
    }

    public static Singleton2 getInstance() {
        return instance;
    }

}
