import java.util.AbstractSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class SlowSet<E> extends AbstractSet<E> {
    private List<E> linkedList = new LinkedList<E>();

    public int size() {
        return linkedList.size();
    }

    public Iterator<E> iterator() {
        return linkedList.iterator();
    }

    public boolean add(E e) {
        Iterator<E> iterator = iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (element != null && element.equals(e)) {
                return false;
            }
        }
        linkedList.add(e);
        return true;
    }
}