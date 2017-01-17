import java.util.*;

enum Note{
        MIDDLE_C,C_SHARP,B_FLAT;
        }

class Instrument {
    void play(Note note) {
        System.out.println("Instrument.play(" + note + ")");
    }

    public String toString() {
        return "Instrument";
    }

    void adjust() {
        System.out.println("Adjust instrument");
    }
}

class Wind extends Instrument {
    void play(Note note) {
        System.out.println("Wind.play(" + note + ")");
    }

    public String toString() {
        return "Wind";
    }

    void adjust() {
        System.out.println("Adjust wind");
    }
}

class Stringed extends Instrument {
    void play(Note note) {
        System.out.println("Stringed.play(" + note + ")");
    }

    public String toString() {
        return "Stringed";
    }

    void adjust() {
        System.out.println("Adjust strined");
    }
}

class Woodwind extends Wind {
    void play(Note note) {
        System.out.println("Woodwind.play(" + note + ")");
    }

    public String toString() {
        return "Woodwind";
    }
}

class Brass extends Wind {
    void play(Note note) {
        System.out.println("Brass.play(" + note + ")");
    }

    void adjust() {
        System.out.println("Adjust brass");
    }
}

class InstrumentGenerator {
    static Random random = new Random();

    static Instrument next() {
        switch (random.nextInt(5)) {
            case 0:
                return new Instrument();
            case 1:
                return new Wind();
            case 2:
                return new Stringed();
            case 3:
                return new Woodwind();
            case 4:
                return new Brass();
        }
        return new Instrument();
    }
}

public class ExerciseSixToEight {
    public static void tune(Instrument instrument) {
        instrument.play(Note.MIDDLE_C);
    }

    public static void tuneAll(Instrument[] instruments) {
        for (Instrument instrument : instruments) {
            System.out.println(instrument);
            tune(instrument);
        }
    }

    public static void main(String[] args) {
        Instrument[] orchestra = new Instrument[10];
        for (int i = 0; i < 10; ++i) {
            orchestra[i] = InstrumentGenerator.next();
        }
        tuneAll(orchestra);
    }
}