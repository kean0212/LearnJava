import java.util.ArrayList;

class Gerbil {
    int gerbilNumber;

    Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    void hop() {
        System.out.println("Gerbil " + this.gerbilNumber + " is hopping");
    }
}

public class ExerciseOne {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbils = new ArrayList<Gerbil>();
        for (int i = 0; i < 10; ++i) {
            gerbils.add(new Gerbil(i));
        }

        for (Gerbil gerbil : gerbils) {
            gerbil.hop();
        }
    }
}