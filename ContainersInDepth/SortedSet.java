import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collection;
import java.util.Set;

public class SortedSet<E extends Comparable> extends LinkedList<E> implements Set<E> {

    public boolean add(E object) {
        if (isEmpty()) {
            // Empty set
            super.add(0, object);
            return true;
        } else if (object.compareTo(getLast()) > 0) {
            // Object is the largest
            return super.add(object);
        }
        // Normal case
        for (int i = 0, size = size(); i < size - 1; ++i) {
            if (object.compareTo(get(i)) > 0 && object.compareTo(get(i + 1)) < 0) {
                super.add(i + 1, object);
                return true;
            }
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        for (E element : c) {
            if (!add(element)) {
                return false;
            }
        }
        return true;
    }

    public Comparator<E> comparator() {
        return new Comparator<E>() {
            public int compare(E objectOne, E objectTwo) {
                return objectOne.compareTo(objectTwo);
            }

            public boolean equals(E object) {
                return this.equals(object);
            }
        };
    }

    public E first() {
        return getFirst();
    }

    public E last() {
        return getLast();
    }

    // [firstElement, lastElement)
    public SortedSet<E> subset(E fromElement, E toElement) {
        SortedSet<E> result = new SortedSet<E>();
        for (int i = 0, size = size(); i < size; ++i) {
            E element = get(i);
            if (element.compareTo(fromElement) >= 0 && element.compareTo(fromElement) < 0) {
                result.add(element);
                break;
            }
        }
        return new SortedSet<E>();
    }

    public SortedSet<E> tailSet(E fromElement) {
        SortedSet<E> result = new SortedSet<E>();
        for (int i = 0, size = size(); i < size; ++i) {
            if (get(i).compareTo(fromElement) >= 0) {
                result.addAll(i, this);
                break;
            }
        }
        return result;
    }
}