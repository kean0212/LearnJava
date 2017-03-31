import java.util.HashMap;
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

public class GerbilHashMap {
    public static void main(String[] args) {
        HashMap<String, Gerbil> gerbilHashMap = new HashMap<String, Gerbil>();
        gerbilHashMap.put("fuzzy", new Gerbil(0));
        gerbilHashMap.put("slim", new Gerbil(1));
        gerbilHashMap.put("cute", new Gerbil(2));
        gerbilHashMap.put("funny", new Gerbil(3));
        gerbilHashMap.put("fit", new Gerbil(4));

        Iterator<String> iterator = gerbilHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            gerbilHashMap.get(iterator.next()).hop();
        }
    }
}