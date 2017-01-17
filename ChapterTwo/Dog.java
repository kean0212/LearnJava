import java.util.*;

public class Dog {
    String name;
    String says;

    public static void main(String[] args) {
        Dog spot = new Dog();
        spot.name = "spot";
        spot.says = "Ruff!";

        Dog scruffy = new Dog();
        scruffy.name = "scruffy";
        scruffy.says = "Wurf!";

        System.out.println(spot.name + ": " + spot.says);
        System.out.println(scruffy.name + ": " + scruffy.says);

        Dog newDog = spot;
        System.out.println("newDog == spot: " + (newDog == spot));
        System.out.println("newDog.equals(spot): " + (newDog.equals(spot)));
    }
}