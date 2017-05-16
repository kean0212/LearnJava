import java.util.Map;

public class SimpleHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> capitals = Countries.capitals(10);
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<String, String>(capitals);
        Util.println(simpleHashMap);
        Util.println("number of collisions: " + simpleHashMap.getNumberOfCollisions()); // 0

        simpleHashMap.putAll(capitals);
        Util.println(simpleHashMap);
        Util.println("size of collisions: " + simpleHashMap.size());
        Util.println("number of collisions: " + simpleHashMap.getNumberOfCollisions()); // size
    }
}