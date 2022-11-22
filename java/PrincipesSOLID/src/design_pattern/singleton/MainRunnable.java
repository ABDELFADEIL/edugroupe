package design_pattern.singleton;

public class MainRunnable implements Runnable{


    @Override
    public void run() {
            System.out.println("Thread " + Thread.currentThread().getName());
            //Singleton singleton = Singleton.getInstance();
            //Singleton singleton = Singleton.getInstanceNonSync();
            Singleton2 singleton2 = Singleton2.getInstance();
    }
}
