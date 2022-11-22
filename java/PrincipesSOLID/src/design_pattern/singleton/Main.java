package design_pattern.singleton;

public class Main {




    public static void main(String[] args) {
        MainRunnable runnable = new MainRunnable();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            Thread thread1 =new Thread(runnable);
            thread1.start();
        }
        System.out.println("Execution time : " + (System.currentTimeMillis() - start));
    }
}
