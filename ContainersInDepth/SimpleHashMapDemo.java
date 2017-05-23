import java.util.Map;

public class SimpleHashMapDemo {
    public static void main(String[] args) {
        Map<String, String> capitals = Countries.capitals(10);
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<String, String>(capitals);
        Util.println("simpleHashMap: "+simpleHashMap);
        Util.println("simpleHashMap.getNumberOfCollisions(): " + simpleHashMap.getNumberOfCollisions()); // 0

        simpleHashMap.putAll(capitals);
        Util.println("simpleHashMap: "+simpleHashMap);

        Util.println("simpleHashMap.size(): " + simpleHashMap.size());
        Util.println("simpleHashMap.getNumberOfCollisions(): " + simpleHashMap.getNumberOfCollisions()); // size
        Util.println("simpleHashMap.getNumberOfProbes(): " + simpleHashMap.getNumberOfProbes()); // size

        simpleHashMap.clear();
        Util.println("after clear(): " + simpleHashMap);

        simpleHashMap.putAll(capitals);
        Util.println("simpleHashMap: "+simpleHashMap);

        Util.println("simpleHashMap.remove(\"CAPE VERDE\"): " + simpleHashMap.remove("CAPE VERDE"));
        Util.println("simpleHashMap: "+simpleHashMap);

        Util.println("simpleHashMap.remove(\"hahaha\"): " + simpleHashMap.remove("hahaha"));
        Util.println("simpleHashMap: "+simpleHashMap);

        Util.println("simpleHashMap.containsKey(\"CAPE VERDE\"): " + simpleHashMap.containsKey("CAPE VERDE"));
        Util.println("simpleHashMap.containsKey(\"ANGOLA\"): " + simpleHashMap.containsKey("ANGOLA"));
        Util.println("simpleHashMap.keySet(): " + simpleHashMap.keySet());
        Util.println("simpleHashMap.isEmpty(): " + simpleHashMap.isEmpty());
        Util.println("simpleHashMap.size(): " + simpleHashMap.size());
        Util.println("simpleHashMap.values(): " + simpleHashMap.values());

        SimpleHashMap<String, String> simpleHashMapCopy = new SimpleHashMap<String, String>(capitals);
        Util.println("simpleHashMap == simpleHashMapCopy: " + (simpleHashMap == simpleHashMapCopy));
    }
}