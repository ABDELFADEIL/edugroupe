package hello;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Hello {


    public static int getSum(int [] tabEnt){
        int sum = 0;
        for (int i = 0; i < tabEnt.length; i++) {
            sum += tabEnt[i];
        }
        return sum;
    }

    /**
     *
     * @param tabEnt
     * @return
     */
    public static int getMax(int [] tabEnt){
        int max = tabEnt[0];
        for (int i = 1; i < tabEnt.length; i++) {
             if (tabEnt[i] > max){
                 max = tabEnt[i];
             }
        }
        return max;
    }

    /**
     *
     * @param tabEnt
     * @return min
     */
    public static int getMin(int [] tabEnt){
        int min = tabEnt[0];
        for (int i = 1; i < tabEnt.length; i++) {
            if (min > tabEnt[i]) min = tabEnt[i];
        }
        return min;
    }
    public static boolean getIsOrdered(int [] tabEnt){
        int compare = tabEnt[0];
        boolean ordered = true;
        for (int i = 1; i < tabEnt.length; i++) {
            if (compare > tabEnt[i]){
                ordered = false;
                break;
            }
            compare = tabEnt[i];
        }
        return ordered;
    }

    public static int [] orderedReverse(int [] tabEnt){
        int [] reversedArray = new int [tabEnt.length];
        int counter = 0;
        for (int i  = tabEnt.length - 1; i >= 0; i--) {
            reversedArray[counter] = tabEnt[i];
            counter++;
        }
        return reversedArray;
    }

    /**
     *
     * @param tabEnt
     * @return
     */
    public static boolean isPositif(int [] tabEnt){
        boolean positif = true;
        for (int i = 0; i < tabEnt.length; i++) {
            if (tabEnt[i] < 0){
                positif = false;
                break;
            }
        }
        return positif;
    }
    // getProportionNulls
    public static void getProportionNulls(int [] tabEnt){
        for (int i = 0; i < tabEnt.length; i++) {
            if (tabEnt[i] == 0){
                System.out.println("Element vide ou valeur = 0 : " + tabEnt[i]);
            }
        }
    }

    public static int getSumOfOddNumber(int [] tabEnt){
        int sum = 0;
        for (int i = 0; i < tabEnt.length; i++) {
            if ((tabEnt[i] % 2) != 0){
                sum += tabEnt[i];
            }
        }
        return sum;
    }
// tableaux multidimensional
public static boolean isPositifMultidimensional(int [] [] tabEnt){
    boolean positif = true;
    outer: for (int i = 0; i < tabEnt.length; i++) {
        for (int j = 0; j < tabEnt[i].length; j++) {
            if (tabEnt[i][j] < 0){
                positif = false;
                break outer;
            }
        }
    }
    return positif;
}
    // getProportionNulls
    public static void getProportionNullsMultidimensional(int [][] tabEnt){
        for (int i = 0; i < tabEnt.length; i++) {
            for (int j = 0; j < tabEnt[i].length; j++) {
                if (tabEnt[i][j] == 0){
                    System.out.println("Element vide ou valeur = 0 : " + tabEnt[i][j]);
                }
            }
        }
    }

    public static int getSumOfOddNumberMultidimensional(int [][] tabEnt){
        int sum = 0;
        for (int i = 0; i < tabEnt.length; i++) {
            for (int j = 0; j < tabEnt[i].length; j++) {
                if ((tabEnt[i][j] % 2) != 0){
                    sum += tabEnt[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int table [] = {0,1,-2,3};
        Arrays.asList(table).forEach(System.out::println);
        System.out.println("sum of the table : " + getSum(table));
        System.out.println("sum of the table using stream: " + getSumLambda(table));
        System.out.println("max of the table : " + getMax(table));
        System.out.println("max of the table using stream: " + getMaxLambda(table));
        System.out.println("min of the table : " + getMin(table));
        System.out.println("min of the table using stream: " + getMinLambda(table));
        System.out.println("La table est ordonné à l'enverse: " + getIsOrdered(table));
        System.out.println("La table est ordonné à l'enverse lambda: " + getIsOrderedLambda(table));
        System.out.println("reversed table : " + Arrays.toString(orderedReverse(table)));
        System.out.println("Is positif " + isPositif(table));
        getProportionNulls(table);
        System.out.println("Sum of odd numbers : " + getSumOfOddNumber(table));

    }
//   ex lambda
public static int getSumLambda(int [] tabEnt){
    return Arrays.stream(tabEnt).sum();
}
    public static int getMaxLambda(int [] tabEnt){
        return Arrays.stream(tabEnt).max().orElseThrow();
    }
    public static int getMinLambda(int [] tabEnt){
        return Arrays.stream(tabEnt).min().orElseThrow();
    }
    public static boolean getIsOrderedLambda(int [] tabEnt){
        int[] reverseSortedTabEnt = Arrays.stream(tabEnt).boxed()
                .sorted(Comparator.reverseOrder()).mapToInt(Integer::intValue).toArray();
        return Arrays.equals(tabEnt, reverseSortedTabEnt);
    }

}