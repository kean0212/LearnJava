import java.util.*;

interface Factory<T> {
    T create();
}

class Part {
    public String toString() {
        return getClass().getSimpleName();
    }

    static List<Class<? extends Part>> parts = new ArrayList<Class<? extends Part>>();

    static {
        parts.add(FuelFilter.class);
        parts.add(AirFilter.class);
        parts.add(CabinAirFilter.class);
        parts.add(OilFilter.class);
        parts.add(FanBelt.class);
        parts.add(PowerSteeringBelt.class);
        parts.add(GeneratorBelt.class);
    }

    private static Random random = new Random(212);

    public static Part createRandom() {
        int index = random.nextInt(parts.size());
        try {
            return parts.get(index).newInstance();
        } catch (InstantiationException|IllegalAccessException  e) {
            throw new RuntimeException(e);
        }
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
}

class AirFilter extends Filter {
}

class CabinAirFilter extends Filter {
}

class OilFilter extends Filter {
}

class Belt extends Part {
}

class FanBelt extends Belt {
}

class PowerSteeringBelt extends Belt {
}

class GeneratorBelt extends Belt {
}

public class Exercise14 {
    public static void main(String[] args) {
        for (int i = 0; i < 10; ++i) {
            System.out.println(Part.createRandom());
        }
    }
}
