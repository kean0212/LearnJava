import java.util.LinkedList;
import java.util.Comparator;
import java.util.Collection;
import java.util.Set;

public class SortedSet<E extends Comparable> extends LinkedList<E> implements Set<E> {

    public boolean add(E object) {
        if (isEmpty() || object.compareTo(getFirst()) < 0) {
            // Empty set or object is the smallest
            super.add(0, object);
            return true;
        } else if (object.compareTo(getLast()) > 0) {
            // Object is the largest
            super.add(object);
            return true;
        } else {
            // Normal case
            for (int i = 0, size = size(); i < size - 1; ++i) {
                if (object.compareTo(get(i)) > 0 && object.compareTo(get(i + 1)) < 0) {
                    super.add(i + 1, object);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        boolean isChanged = false;
        for (E element : c) {
            isChanged = add(element);
        }
        return isChanged;
    }

    public Comparator<E> comparator() {
        return new Comparator<E>() {
            public int compare(E objectOne, E objectTwo) {
                return objectOne.compareTo(objectTwo);
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
    public SortedSet<E> subSet(E fromElement, E toElement) {
        SortedSet<E> result = new SortedSet<E>();
        for (int i = 0, size = size(); i < size; ++i) {
            E element = get(i);
            if (element.compareTo(fromElement) >= 0 && element.compareTo(toElement) < 0) {
                result.add(element);
            }
        }
        return result;
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