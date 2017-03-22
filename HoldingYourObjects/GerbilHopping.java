import java.util.ArrayList;

class Gerbil {
    int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public void hop() {
        System.out.println("Gerbil number is: " + gerbilNumber);
    }
}

public class GerbilHopping {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbilArrayList = new ArrayList<Gerbil>();
        int count = Integer.parseInt(args[0]);
        for (int i = 0; i < count; ++i) {
            gerbilArrayList.add(new Gerbil(i));
        }
        for (Gerbil gerbil : gerbilArrayList) {
            gerbil.hop();
        }
    }
}