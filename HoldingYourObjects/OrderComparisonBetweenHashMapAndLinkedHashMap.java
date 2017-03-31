import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.LinkedHashMap;

public class OrderComparisonBetweenHashMapAndLinkedHashMap {
    public static void main(String[] args) {
        Map<String, Integer> productHashMap = new HashMap<String, Integer>();
        productHashMap.put("MacBook", 2500);
        productHashMap.put("Monitor", 500);
        productHashMap.put("Mouse", 100);
        productHashMap.put("Keyboard", 400);
        productHashMap.put("Book", 999999);
        System.out.println("HashMap: " + productHashMap);

        Map<String, Integer> productTreeMap = new TreeMap<String, Integer>(productHashMap);
        System.out.println("LinkedTreeMap: " + productTreeMap);
        System.out.println("LinkedTreeMap keyset: " + productTreeMap.keySet());

        Map<String, Integer> productLinkedHashMap = new LinkedHashMap<String, Integer>();
        for (String product : productTreeMap.keySet()) {
            productLinkedHashMap.put(product, productTreeMap.get(product));
        }
        System.out.println("LinkedHashMap: " + productLinkedHashMap);
    }
}