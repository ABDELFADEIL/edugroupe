package design_pattern.singleton;

public class Singleton {

    private static Singleton instance = null;
    private static int nb = 0;
    private Singleton() {
        System.out.println("Je suis l'instance n° " + ++nb);
    }

    public static Singleton getInstance() {
        synchronized (Singleton.class){
            if(instance == null){
                instance = new Singleton();
            }
        }
        return instance;
    }

    public static Singleton getInstanceNonSync() {
            if(instance == null){
                instance = new Singleton();
        }
        return instance;
    }
}
