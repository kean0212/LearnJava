import java.util.Map;

public class MapEntry<K extends Comparable, V> implements Map.Entry<K, V>, Comparable<MapEntry<K, V>> {
    private K key;
    private V value;
    private MapEntry<K, V> next;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public MapEntry(K key, V value, MapEntry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V result = this.value;
        this.value = value;
        return result;
    }

    public MapEntry getNext() {
        return next;
    }

    public MapEntry setNext(MapEntry next) {
        MapEntry result = this.next;
        this.next = next;
        return result;
    }

    public boolean hasNext() {
        return next != null;
    }

    public int hashCode() {
        return (key == null ? 0 : key.hashCode()) ^ (value == null ? 0 : value.hashCode());
    }

    public boolean equals(Object object) {
        if (!(object instanceof MapEntry))
            return false;
        MapEntry mapEntry = (MapEntry) object;
        return (key == null ? mapEntry.getKey() == null : key.equals(mapEntry.getKey())) &&
                (value == null ? mapEntry.getValue() == null : value.equals(mapEntry.getValue()));
    }

    public String toString() {
        return key + "=" + value;
    }

    public int compareTo(MapEntry<K, V> other) {
        return key.compareTo(other.key);
    }
}
