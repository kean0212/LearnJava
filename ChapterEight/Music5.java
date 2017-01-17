import java.util.*;

enum Note{
        MIDDLE_C,C_SHARP,LOW_C
        }

interface Instrument {
    void adjust();
}

interface Playable {
    void play(Note note);
}

class Wind implements Instrument, Playable {
    public void adjust() {
        System.out.println(this + " adjust");
    }

    public void play(Note n) {
        System.out.println(this + " " + n);
    }

    public String toString() {
        return "Wind";
    }
}

class Percussion implements Instrument, Playable {
    public void adjust() {
        System.out.println(this + " adjust");
    }

    public void play(Note n) {
        System.out.println(this + " " + n);
    }

    public String toString() {
        return "Percussion";
    }
}

public class Music5 {
    static void tune(Playable playable) {
        playable.play(Note.MIDDLE_C);
    }

    public static void main(String[] args) {
        Playable[] orchestra = {new Wind(), new Percussion(), new Percussion()};
        for (Playable playable : orchestra) {
            tune(playable);
        }
    }
}
