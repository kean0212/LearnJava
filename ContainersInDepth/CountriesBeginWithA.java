import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.HashSet;

public class CountriesBeginWithA {
    private static boolean isBeginWithA(String string) {
        return string.charAt(0) == 'A';
    }

    public static void main(String[] args) {
        Map<String, String> resultMap = new HashMap<String, String>();
        Map<String, String> capitals = Countries.capitals();
        for (Map.Entry<String, String> entry : capitals.entrySet()) {
            if (isBeginWithA(entry.getKey())) {
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }
        System.out.println("Result Map: " + resultMap);

        Set<String> resultSet = new HashSet<String>();
        for (String name : Countries.names()) {
            if (isBeginWithA(name)) {
                resultSet.add(name);
            }
        }
        System.out.println("Result Set: " + resultSet);
    }
}