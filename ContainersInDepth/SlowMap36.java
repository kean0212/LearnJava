import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;
import java.util.Collections;

public class SlowMap36<K extends Comparable, V> extends AbstractMap<K, V> {
    private List<MapEntry<K, V>> entries = new ArrayList<>();
    Set<Map.Entry<K, V>> entrySet = new EntrySet();

    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public int size() {
            return entries.size();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                int index = -1;

                public boolean hasNext() {
                    return index < size() - 1;
                }

                @SuppressWarnings("unchecked")
                public Map.Entry<K, V> next() {
                    return entries.get(++index);
                }

                public void remove() {
                    entries.remove(index);
                }
            };
        }
    }

    public V put(K key, V value) {
        int size = entries.size();
        for (int i = 0; i < size; ++i) {
            MapEntry<K, V> entry = entries.get(i);
            if (entry != null && areKeysEqual(entry.getKey(), key)) {
                return entry.setValue(value);
            }
        }
        entries.add(new MapEntry(key, value));
        Collections.sort(entries);
        return null;
    }

    private boolean areKeysEqual(K entryKey, K key) {
        return entryKey == null ? entryKey == key : entryKey.equals(key);
    }

    public V get(Object key) { // key is type Object, not K
        int index = Collections.binarySearch(entries, new MapEntry<K, V>((K) key, null));
        if (index < 0) {
            return null;
        }
        MapEntry<K, V> entry = entries.get(index);
        return entry.getValue();
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet;
    }

    public static void main(String[] args) {
        SlowMap<String, String> map = new SlowMap<String, String>();
        map.putAll(Countries.capitals(15));
        Util.println(map);
        Util.println(map.get("BULGARIA"));
        Util.println(map.entrySet());
    }
}
