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
            int bucketIndex = 0;
            int elementIndex = -1;

            // Update the indices to the next element
            public boolean hasNext() {
                LinkedList<E> bucket = buckets[bucketIndex];
                if (bucket != null && elementIndex < bucket.size() - 1) {
                    elementIndex++;
                    return true;
                }
                for (int i = bucketIndex + 1; i < SIZE; ++i) {
                    if (buckets[i] != null) {
                        bucketIndex = i;
                        elementIndex = 0;
                        return true;
                    }
                }
                return false;
            }

            public E next() {
                return buckets[bucketIndex].get(elementIndex);
            }

            public void remove() {
                buckets[bucketIndex].remove(elementIndex);
                if (buckets[bucketIndex].isEmpty()) {
                    buckets[bucketIndex] = null;
                }
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
        count++;
        return true;
    }
}