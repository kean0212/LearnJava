import java.util.*;

class Shared {
    int referenceCount = 0;
    static int count = 0;
    int id = count++;
    void refAdd() {
        referenceCount++;
    }
}

class Description {
    Description(String description) {
        System.out.println("Description: " + description);
    }
}

abstract class Rodent {
    private Shared shared;
    private Description description = new Description("Rodent");

    public Rodent() {}

    public Rodent(Shared shared) {
        this.shared = shared;
        shared.refAdd();
    }

    public String toString() {
        return "Rodent";
    }
}

class Mouse extends Rodent {
    private Description description = new Description("Mouse");

    public String toString() {
        return "Mouse";
    }
}

class Gerbil extends Rodent {
    private Description description = new Description("Gerbil");

    public String toString() {
        return "Gerbil";
    }
}

class Hamster extends Rodent {
    private Description description = new Description("Hamster");

    public String toString() {
        return "Hamster";
    }
}

public class ExerciseOne {
    public static void main(String[] args) {
        Rodent[] rodents = {new Mouse(), new Gerbil(), new Hamster()};//, new Rodent()};
        for (Rodent rodent : rodents) {
            System.out.println(rodent);
        }

        Shared shared = new Shared();
        Rodent[] rodentsTwo = {};//{new Rodent(shared), new Rodent(shared), new Rodent(shared)};
        System.out.println(shared.referenceCount);
    }
}