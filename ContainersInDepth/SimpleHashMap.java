import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ListIterator;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    private int numberOfCollisions = 0;

    @SuppressWarnings("unchecked")
    private LinkedList<Map.Entry<K, V>>[] buckets = new LinkedList[SIZE];

    @SuppressWarnings("unchecked")
    public SimpleHashMap(Map<? extends K, ? extends V> map) {
        for (Map.Entry mapEntry : map.entrySet()) {
            put((K) mapEntry.getKey(), (V) mapEntry.getValue());
        }
    }

    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }

    public V put(K key, V value) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<Map.Entry<K, V>>();
        } else {
            numberOfCollisions++;
        }

        V oldValue = null;
        boolean isFound = false;
        LinkedList<Map.Entry<K, V>> bucket = buckets[index];
        ListIterator<Map.Entry<K, V>> listIterator = bucket.listIterator();
        while (listIterator.hasNext()) {
            Map.Entry<K, V> entry = listIterator.next();
            K entryKey = entry.getKey();
            if (entryKey.equals(key)) {
                isFound = true;
                oldValue = entry.getValue();
                listIterator.set(new MapEntry<K, V>(key, value));
                break;
            }
        }
        if (!isFound) {
            bucket.add(new MapEntry<K, V>(key, value));
        }
        return oldValue;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        LinkedList<Map.Entry<K, V>> bucket = buckets[index];
        if (bucket != null) {
            for (Map.Entry<K, V> mapEntry : bucket) {
                if (mapEntry.getKey().equals(key)) {
                    return mapEntry.getValue();
                }
            }
        }
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entrySet = new HashSet<Map.Entry<K, V>>();
        for (LinkedList<Map.Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Map.Entry<K, V> mapEntry : bucket) {
                    entrySet.add(mapEntry);
                }
            }
        }
        return entrySet;
    }

    @SuppressWarnings("unchecked")
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry mapEntry : map.entrySet()) {
            put((K) mapEntry.getKey(), (V) mapEntry.getValue());
        }
    }
}