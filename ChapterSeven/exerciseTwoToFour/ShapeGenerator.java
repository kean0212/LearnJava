package exerciseTwoToFour;

import java.util.Random;

public class ShapeGenerator {
    private static Random random = new Random();
    public static Shape next() {
        switch (random.nextInt(2)) {
            case 0:
                return new Circle();
            case 1:
                return new Rectangle();
        }
        return new Shape();
    }
}