import java.util.Arrays;

public class Main {

    public static void printCars(String[] tab) {
        for (int i = 0; i < tab.length; i++) {
            System.out.println(tab[i]);
        }
    }

    public static void main(String[] args) {
        String cars[] = {"Volve", "Renault", "Ford", "Mazda"};
        System.out.println(cars[0]); // Accès à l'élement de l'indice 0

        // afficher du tableau via boucle for
        System.out.println("*****************//////////////// Boucle for ////////////////////*******************");
        for (int i = 0; i < cars.length; i++) {
            System.out.print(cars[i] + " ");
        }
        System.out.println();
        // changement de valeur d'un tableau
        cars[1] = "Opel";
        // foreach
        System.out.println("*****************//////////////// Foreach ////////////////////*******************");
        Arrays.asList(cars).forEach(System.out::println);

        System.out.println("*****************///////////////// table MultiDimension ////////////////////*******************");
        int[][] myNumber = {{1, 2, 3, 4}, {5, 6, 7}};
        int x = myNumber[1][2];
        System.out.println("My Number value is : " + x);

        for (int i = 0; i < myNumber.length; i++) {
            for (int j = 0; j < myNumber[i].length; j++) {
                System.out.println(myNumber[i][j]);
            }
        }
        // instanciation : creation de l'objet chat fleix à partir de la classe Chat

        Chat felix = new Chat("Félix", 'F', 2, 1.4, "Blanc");
        Chat M = new Chat("M", 'F', 5, 3, "Noir");
        felix.breathe();
        System.out.println(felix.toString());


    }
}
