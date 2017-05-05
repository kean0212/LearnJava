import java.util.AbstractMap;
import java.util.Map;
import java.util.Set;
import java.util.AbstractSet;
import java.util.LinkedHashSet;
import java.util.Iterator;

public class CountingMapData extends AbstractMap<Integer, String> {
    private int size;
    private static String[] chars = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z".split(" ");

    public CountingMapData(int size) {
        if (size < 0) {
            this.size = 0;
        }
        this.size = size;
    }

    private static class Entry implements Map.Entry<Integer, String> {
        int index;

        Entry(int index) {
            this.index = index;
        }

        public boolean equals(Object o) {
            return Integer.valueOf(index).equals(o);
        }

        public Integer getKey() {
            return index;
        }

        public String getValue() {
            return chars[index % chars.length] + Integer.toString(index / chars.length);
        }

        public String setValue(String value) {
            throw new UnsupportedOperationException();
        }

        public int hashCode() {
            return Integer.valueOf(index).hashCode();
        }
    }

    private static class EntrySet extends AbstractSet<Map.Entry<Integer, String>> {
        private int size;

        public int size() {
            return size;
        }

        public EntrySet(int size) {
            this.size = Math.max(0, size);
        }

        public Iterator<Map.Entry<Integer, String>> iterator() {
            return new Iterator<Map.Entry<Integer, String>>() {
                private int index = -1;

                public boolean hasNext() {
                    index++;
                    return index < size;
                }

                public Map.Entry<Integer, String> next() {
                    return new Entry(index);
                }
            };
        }
    }

    public Set<Map.Entry<Integer, String>> entrySet() {
        return new EntrySet(size);
    }

    public static void main(String[] args) {
        System.out.println(new CountingMapData(60));
    }
}
