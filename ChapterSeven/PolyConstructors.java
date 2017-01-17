import java.util.*;

class Glyph {
    void draw() {
        System.out.println("Glyph.draw()");
    }

    Glyph() {
        System.out.println("Glyph() before draw()");
        draw();
        System.out.println("Glyph() after draw()");
    }
}

class RoundGlyph extends Glyph {
    int radius = 1;

    RoundGlyph(int radius) {
        this.radius = radius;
    }

    void draw() {
        System.out.println("RoundGlyph with radius: " + radius);
    }
}

class RectangularGlyph extends Glyph {
    int width = 3;
    int length = 4;

    RectangularGlyph(int width, int length) {
        this.width = width;
        this.length = length;
    }

    void draw() {
        System.out.println("RectangularGlyph with width: " + width + " length: " + length);
    }
}

public class PolyConstructors {
    public static void main(String[] args) {
        new RoundGlyph(5);
        new RectangularGlyph(9, 12);
    }
}