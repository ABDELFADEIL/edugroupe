package collection;

import heritage.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Lists {


    public static void main(String[] args) {
        ArrayList<String> langages = new ArrayList<>();
        List<String> myList2 = Arrays.asList("Ziad", "Eric", "Francine");
        System.out.println(langages.indexOf("Eric"));
        Collections.sort(myList2);
        System.out.println(myList2);
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        System.out.println("Nombre de personnes instanciées " + Person.counter);
    }
}
