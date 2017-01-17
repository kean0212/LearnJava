import java.util.*;

class Grain {
    public String toString() {
        return "Grain";
    }
}

class Wheat extends Grain {
    public String toString() {
        return "Wheat";
    }
}

class Mill {
    Grain process() {
        return new Grain();
    }
}

class WheatMill extends Mill {
    Wheat process() {
        return new Wheat();
    }
}

public class CovariantReturn {
    public static void main(String[] args) {
        Grain grain;
        Mill mill = new Mill();
        grain = mill.process();
        System.out.println(grain);

        mill = new WheatMill();
        grain = mill.process();
        System.out.println(grain);
    }
}