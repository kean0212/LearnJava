import java.util.*;

class Cycle {
    Cycle() {
        System.out.println("Cycle");
    }

    int wheels() {
        return 0;
    }
}

class Unicycle extends Cycle {
    Unicycle() {
        System.out.println("Unicycle");
    }

    void balance() {
        System.out.println("Unicycle.balance()");
    }
}

class Bicycle extends Cycle {
    Bicycle() {
        System.out.println("Bicycle");
    }
}

public class ExerciseOne {
    static void ride(Cycle cycle) {
        System.out.println("wheels number: " + cycle.wheels());
        System.out.println("Ride");
    }

    public static void main(String[] args) {
        Cycle cycle = new Cycle();
        ride(cycle);

        Unicycle unicycle = new Unicycle();
        ride(unicycle);

        Bicycle bicycle = new Bicycle();
        ride(bicycle);

        Cycle[] cycles = {new Unicycle(), new Bicycle(), new Bicycle(), new Unicycle()};
        for (Cycle cycle1 : cycles) {
            if (cycle1 instanceof Unicycle){
                ((Unicycle)cycle1).balance();
            }
        }
    }
}
