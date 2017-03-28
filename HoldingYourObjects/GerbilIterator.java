import java.util.ArrayList;
import java.util.Iterator;

class Gerbil {
    int gerbilNumber;

    public Gerbil(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }

    public void hop() {
        System.out.println("Gerbil number is: " + gerbilNumber);
    }
}

public class GerbilIterator {
    public static void main(String[] args) {
        ArrayList<Gerbil> gerbilArrayList = new ArrayList<Gerbil>();
        int count = Integer.parseInt(args[0]);
        for (int i = 0; i < count; ++i) {
            gerbilArrayList.add(new Gerbil(i));
        }
        Iterator<Gerbil> iterator = gerbilArrayList.iterator();
        while (iterator.hasNext()) {
            iterator.next().hop();
        }
    }
}