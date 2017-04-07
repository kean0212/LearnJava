import java.util.Collection;
import java.util.Iterator;

public class CollectionSequence implements Collection<Integer> {
    private Integer[] array = new Integer[7];

    public boolean add(Integer element) {
        throw new UnsupportedOperationException();
    }

    public boolean addAll(Collection<? extends Integer> collection) {
        throw new UnsupportedOperationException();
    }

    public void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean contains(Object object) {
        throw new UnsupportedOperationException();
    }

    public boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean equals(CollectionSequence another) {
        throw new UnsupportedOperationException();
    }

    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private int index = 0;

            public boolean hasNext() {
                return index < array.length;
            }

            public Integer next() {
                return array[index];
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return array.length;
    }

    public Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public <Integer> Integer[] toArray(Integer[] array) {
        throw new UnsupportedOperationException();
    }

    public static void display(Collection collection) {
        System.out.println("display collection");
    }

    public static void display(Iterator iterator) {
        System.out.println("display iterator");
    }

    public static void main(String[] args) {
        CollectionSequence collectionSequence = new CollectionSequence();
        display(collectionSequence);
        display(collectionSequence.iterator());
    }
}
