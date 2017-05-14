import java.util.AbstractMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Map;
import java.util.Iterator;

/*
The 'clear()' method in AbstractMap calls 'entrySet().clear()'.
Therefore, to correct the behaviour of 'map.clear()', we need to change 'entrySet()'.
It should be a "view" of the entries in the map.
 */
public class SlowMap<K, V> extends AbstractMap<K, V> {
    private List<K> keys = new ArrayList<K>();
    private List<V> values = new ArrayList<V>();
    Set<Map.Entry<K, V>> entrySet = new EntrySet();

    /*
    We use the flyweight pattern.
    To minify the work, we use 'AbstractSet', so that we only need to implement two abstract methods:
    size() and iterator().
    From the documentation of 'AbstractSet', we learn that we need to implement at least 2 methods in the 'Iterator':
    hasNext() and next(), as requested in 'AbstractCollection'.
    Since we need to enable 'map.clear()' which is achieved through "entrySet().clear()",
    and our entrySet is implemented using 'AbstractSet', we need to check how 'abstractSet.clear()' is implemented.
    It turns out that 'clear()' is inherited from 'AbstractCollection' which calls 'Iterator.remove()'.
    Therefore, we need to implement 'remove()' in 'iterator()' too.

    In summary: When 'map.clear()' is called, 'entrySet().clear()' is called.
    Since our 'entrySet()' is backed by 'AbstractSet' which is inherited from 'AbstractCollection' where 'clear()' is
    implemented using 'Iterator.remove()', we implement 'remove()' in 'iterator'.
    The 'remove()' method does the real removal.

    From the source code of JDK1.8, 'keySet()'('AbstractSet')  is backed by 'entrySet()'.
    The 'Iterator()' in 'keySet()' is backed by the 'Iterator' in 'entrySet()'.
    When 'keySet().removeAll()' is called, the 'Iterator' in 'entrySet()' is called.
    Therefore, with our implementation, the 'SlowMap' is also cleared.
     */
    private class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        public int size() {
            return keys.size();
        }

        public Iterator<Map.Entry<K, V>> iterator() {
            return new Iterator<Map.Entry<K, V>>() {
                int index = -1;

                public boolean hasNext() {
                    return index < size() - 1;
                }

                @SuppressWarnings("unchecked")
                public Map.Entry<K, V> next() {
                    K key = keys.get(++index);
                    V value = values.get(index);
                    return new MapEntry(key, value);
                }

                public void remove() {
                    keys.remove(index);
                    values.remove(index--);
                }
            };
        }
    }

    public V put(K key, V value) {
        V oldValue = get(key); // The old value or null
        if (!keys.contains(key)) {
            keys.add(key);
            values.add(value);
        } else
            values.set(keys.indexOf(key), value);
        return oldValue;
    }

    public V get(Object key) { // key is type Object, not K
        if (!keys.contains(key))
            return null;
        return values.get(keys.indexOf(key));
    }

    public Set<Map.Entry<K, V>> entrySet() {
        return entrySet;
    }

    public static void main(String[] args) {
        SlowMap<String, String> m = new SlowMap<String, String>();
        m.putAll(Countries.capitals(15));
        System.out.println(m);
        System.out.println(m.get("BULGARIA"));
        System.out.println(m.entrySet());
    }
}
