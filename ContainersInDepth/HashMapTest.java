import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest {

    private void test(int initialCapacity, float loadFactor, int size) {
        HashMap<String, String> hashMap = new HashMap(initialCapacity, loadFactor);
        fillHashMap(hashMap, size);
        long duration = countSearchingTime(hashMap);
        String result = String.format("Searching in HashMap [size = %d, capacity = %d, loadFactor = %f] in %d nanoseconds on average",
                size, initialCapacity, loadFactor, duration);
        Util.println(result);
    }

    private void fillHashMap(HashMap<String, String> hashMap, int size) {
        hashMap.putAll(Countries.capitals(size));
    }

    private long countSearchingTime(HashMap<String, String> hashMap) {
        Set<Map.Entry<String, String>> entrySet = hashMap.entrySet();
        long startTime = getCurrentTime();
        for (Map.Entry entry : entrySet) {
            hashMap.get(entry.getKey());
        }
        long duration = getCurrentTime() - startTime;
        return duration / entrySet.size();
    }

    private long getCurrentTime() {
        return System.nanoTime();
    }

    public static void main(String[] args) {
        HashMapTest hashMapTest = new HashMapTest();
        int capitalsSize = Countries.capitals().size();
        hashMapTest.test(capitalsSize, 1.75f, capitalsSize);
        hashMapTest.test(2 * capitalsSize, 1.75f, capitalsSize);
        hashMapTest.test(capitalsSize, 0.25f, capitalsSize);
    }
}