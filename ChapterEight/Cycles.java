import java.util.*;

interface Cycle {
    int wheels();
}

interface CycleFactory {
    Cycle getCycle();
}

class Unicycle implements Cycle {
    public int wheels() {
        return 1;
    }
}

class UnicycleFactory implements CycleFactory {
    public Unicycle getCycle() {
        return new Unicycle();
    }
}

class Bicycle implements Cycle {
    public int wheels() {
        return 2;
    }
}

class BicycleFactory implements CycleFactory {
    public Bicycle getCycle() {
        return new Bicycle();
    }
}

class Tricycle implements Cycle {
    public int wheels() {
        return 3;
    }
}

class TricycleFactory implements CycleFactory {
    public Tricycle getCycle() {
        return new Tricycle();
    }
}

public class Cycles {
    public static void getWheels(CycleFactory cycleFactory) {
        Cycle cycle = cycleFactory.getCycle();
        System.out.println(cycle.wheels());
    }

    public static void main(String[] args) {
        getWheels(new UnicycleFactory());
        getWheels(new BicycleFactory());
        getWheels(new TricycleFactory());
    }
}