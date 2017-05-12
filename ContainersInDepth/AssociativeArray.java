import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class AssociativeArray<K, V> {
    private Object[][] pairs;
    private int index;

    public AssociativeArray(int length) {
        pairs = new Object[length][2];
    }

    public void put(K key, V value) {
        if (index >= pairs.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        pairs[index++] = new Object[]{key, value};
    }

    @SuppressWarnings("unchecked")
    public V get(K key) {
        for (int i = 0; i < index; ++i) {
            if (key.equals(pairs[i][0])) {
                return (V) pairs[i][1];
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < index; ++i) {
            stringBuilder.append(pairs[i][0].toString());
            stringBuilder.append("=");
            stringBuilder.append(pairs[i][1].toString());
            if (i != index - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }

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
