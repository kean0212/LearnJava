import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Iterator;

public class SimpleHashMap<K, V> extends AbstractMap<K, V> {
    static final int SIZE = 997;
    private int numberOfCollisions = 0;
    private int numberOfProbes = 0;

    @SuppressWarnings("unchecked")
    private MapEntry<K, V>[] buckets = new MapEntry[SIZE];

    @SuppressWarnings("unchecked")
    public SimpleHashMap(Map<? extends K, ? extends V> map) {
        putAll(map);
    }

    public int getNumberOfCollisions() {
        return numberOfCollisions;
    }

    public int getNumberOfProbes() {
        return numberOfProbes;
    }

    public V put(K key, V value) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) {
            buckets[index] = new MapEntry(key, value);
            return null;
        }

        numberOfCollisions++;
        MapEntry bucketHead = buckets[index];
        do {
            numberOfProbes++;
            K headKey = (K) bucketHead.getKey();
            V headValue = (V) bucketHead.getValue();
            if (headKey.equals(key)) {
                bucketHead.setValue(value);
                return headValue;
            }
            bucketHead = bucketHead.getNext();
        } while (bucketHead.hasNext());

        bucketHead.setNext(new MapEntry(key, value));
        return null;
    }

    public V get(Object key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        MapEntry<K, V> bucketHead = buckets[index];
        while (bucketHead != null) {
            K headKey = bucketHead.getKey();
            if (headKey.equals(key)) {
                return bucketHead.getValue();
            }
            bucketHead = bucketHead.getNext();
        }
        return null;
    }

    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> entrySet = new HashSet<Map.Entry<K, V>>();
        for (MapEntry<K, V> bucketHead : buckets) {
            while (bucketHead != null) {
                entrySet.add(bucketHead);
                bucketHead = bucketHead.getNext();
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

    public void clear() {
        for (int i = 0; i < SIZE; ++i) {
            buckets[i] = null;// is this necessary?
        }
    }

    @SuppressWarnings("unchecked")
    public V remove(Object key) {
        V oldValue = null;
        int bucketIndex = Math.abs(key.hashCode()) % SIZE;
        MapEntry<K, V> dumbHead = new MapEntry(null, null, buckets[bucketIndex]);
        MapEntry<K,V> head = dumbHead;
        MapEntry<K, V> next = null;
        while ((next = head.getNext()) != null) {
            K nextKey = next.getKey();
            if (nextKey.equals(key)) {
                head.setNext(next.getNext());
                buckets[bucketIndex] = dumbHead.getNext();
                return next.getValue();
            }
            head = next;
        }
        return null;
    }
}