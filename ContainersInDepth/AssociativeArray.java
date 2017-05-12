import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AssociativeArray {
    private static void fill(Map<String, String> map) {
        map.put("sky", "blue");
        map.put("grass", "green");
        map.put("ocean", "dancing");
        map.put("tree", "tall");
        map.put("earth", "brown");
        map.put("sun", "warm");
    }

    public static void main(String[] args) {
        Map<String, String> hashMap = new HashMap<String, String>();
        fill(hashMap);
        Util.println("HashMap: " + hashMap);
        Util.println("ocean: " + hashMap.get("ocean"));

        Map<String, String> treeMap = new TreeMap<String, String>();
        fill(treeMap);
        Util.println("TreeMap: " + treeMap);
        Util.println("ocean: " + treeMap.get("ocean"));

        Map<String, String> linkedHashMap = new LinkedHashMap<String, String>();
        fill(linkedHashMap);
        Util.println("linkedHashMap: " + linkedHashMap);
        Util.println("ocean: " + linkedHashMap.get("ocean"));
    }
}
