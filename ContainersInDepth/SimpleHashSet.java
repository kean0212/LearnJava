import java.util.AbstractSet;
import java.util.LinkedList;
import java.util.Iterator;

public class SimpleHashSet<E> extends AbstractSet<E> {

    private final static int SIZE = 997;

    @SuppressWarnings("unchecked")
    private LinkedList<E>[] buckets = new LinkedList[SIZE];

    private int count = 0;

    public int size() {
        return count;
    }

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return false;
            }

            public E next() {
                return null;
            }

            public void remove() {

            }
        };
    }

    public boolean add(E e) {
        int bucketIndex = Math.abs(e.hashCode()) % SIZE;
        if (buckets[bucketIndex] == null) {
            buckets[bucketIndex] = new LinkedList<E>();
        }
        boolean isFound = false;
        LinkedList<E> bucket = buckets[bucketIndex];
        for (E element : bucket) {
            if (e != null && e.equals(element)) {
                return false;
            }
        }
        bucket.add(e);
        return true;
    }
}