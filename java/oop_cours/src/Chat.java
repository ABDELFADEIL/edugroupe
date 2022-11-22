/**
 * 
 */
public class Chat {

    private String name;
    private char gender;
    private int age;
    private double weight;
    private String color;
    /**
     * Default constructor
     */
    public Chat() {
    }

    public Chat(String name, char gender, int age, double weight, String color) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    /**
     *
     */
    public void breathe() {
        System.out.println("Je respire");
    }
    /**
     * 
     */
    public void eat() {
        System.out.println("Je mange");
    }
    /**
     * 
     */
    public void run() {
        System.out.println("Je cours");
    }
    /**
     * 
     */
    public void sleep() {
        System.out.println("Je dors");
    }
    /**
     * 
     */
    public void neow() {
        System.out.println("Neowwwww !");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "nom='" + name + '\'' +
                ", genre=" + gender +
                ", age=" + age +
                ", poids=" + weight +
                ", couleur='" + color + '\'' +
                '}';
    }

}