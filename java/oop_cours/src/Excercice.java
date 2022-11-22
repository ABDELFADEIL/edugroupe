import java.util.Scanner;

public class Excercice {

    public static void divisiblePar3Test() {
        int number;
        System.out.println("Entrer un entier:");
        Scanner scanner = new Scanner(System.in);
        number = scanner.nextInt();
        if ((number % 3) == 0) {
            System.out.println(number + " est divisible par 3");
        } else {
            System.out.println(number + " n'est pas divisible par 3");
        }
    }

    public static void testImbrique3() {
        int copies;
        double price = 0;
        System.out.println("Nombre de photocopies:");
        Scanner scanner = new Scanner(System.in);
        copies = scanner.nextInt();
        if (copies < 10) {
            price = copies * 0.5;
        } else if (copies >= 10 && copies <= 20) {
            price = copies * 0.4;
        } else {
            price = copies * 0.3;
        }
        System.out.println("Le prix total : " + price);
    }

    public static void main(String[] args) {
        divisiblePar3Test();
        testImbrique3();
    }
}
