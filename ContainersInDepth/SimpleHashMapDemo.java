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
        Util.println("number of probes: " + simpleHashMap.getNumberOfProbes()); // size

        simpleHashMap.clear();
        Util.println("after clear(): " + simpleHashMap);

        simpleHashMap.putAll(capitals);

        Util.println("simpleHashMap.remove(\"CAPE VERDE\"): " + simpleHashMap.remove("CAPE VERDE"));
        Util.println(simpleHashMap);

        Util.println("simpleHashMap.remove(\"hahaha\"): " + simpleHashMap.remove("hahaha"));
        Util.println(simpleHashMap);
    }
}