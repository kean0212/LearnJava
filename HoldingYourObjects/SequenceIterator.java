import java.util.*;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class SequenceIterator {
    List<Object> objectList = new ArrayList();

    void add(Object object) {
        objectList.add(object);
    }

    public Iterator iterator() {
        return objectList.iterator();
    }

    public static void main(String[] args) {
        SequenceIterator sequenceIterator = new SequenceIterator();
        for (int i = 0; i < 10; ++i) {
            sequenceIterator.add(i);
        }
        Iterator<Object> iterator = sequenceIterator.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
