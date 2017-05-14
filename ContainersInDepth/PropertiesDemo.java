import java.util.Properties;
import java.util.Map;

public class PropertiesDemo {
    public static void printKeys(Map<Object, Object> map) {
        Util.print("Size = " + map.size() + ", ");
        Util.print("Keys: ");
        Util.println(map.keySet());
    }

    public static void test(Map<Object, Object> map) {
        Util.print(map.getClass().getSimpleName());
        map.putAll(new CountingMapData(25));
        // Map has "Set" behaviour for keys: equals, hashcode, comparable
        map.putAll(new CountingMapData(25));
        printKeys(map);
        // Producing a collection of values:
        Util.print("Values: ");
        Util.println(map.values());
        Util.println(map);
        Util.println("map.containsKey(11): " + map.containsKey(11));
        Util.println("map.get(11): " + map.get(11));
        Util.println("map.containsValue(\"F0\"): " + map.containsValue("F0"));
        Object key = map.keySet().iterator().next();
        Util.println("First key in map: " +key);
        map.remove(key);
        printKeys(map);
        map.clear();
        Util.println("map.isEmpty(): " + map.isEmpty());
        map.putAll(new CountingMapData(25));
        // Operations on the Set change the Map:
//        map.keySet().removeAll(map.keySet());
        map.keySet().clear();
        Util.println("map.isEmpty(): " + map.isEmpty());
    }

    public static void main(String[] args) {
        test(new Properties());
    }
}