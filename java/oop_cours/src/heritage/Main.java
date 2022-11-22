package heritage;

public class Main {
    public static void main(String[] args) {
        Animal myAnimal = new Animal("Félix", 12);
        myAnimal.run();
        System.out.println(myAnimal.name);
        System.out.println(myAnimal.weight);
        Chien myChien = new Chien("Toto", 25);
        myChien.run();
        System.out.println(myChien.name);
        System.out.println(myChien.weight);
        Chat myChat = new Chat("Titi", 25);
        myChat.run();
        System.out.println(myChat.name);
        System.out.println(myChat.weight);

    }
}
