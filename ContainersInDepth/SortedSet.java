import java.util.LinkedList;
import java.util.Comparator;
import java.util.Set;

public class SortedSet<E extends Comparable> extends LinkedList<E> implements Set<E> {

    public boolean add(E object) {
        return true;
    }

    public Comparator<E> comparator() {
        return new Comparator<E>() {
            public int compare(E objectOne, E objectTwo) {
                return objectOne.compareTo(objectTwo);
            }

            public boolean equals(E object) {
                return true; // todo: need to fix
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
        return new SortedSet<E>();
    }

    public SortedSet<E> tailSet(E fromElement) {
        return new SortedSet<E>();
    }
}