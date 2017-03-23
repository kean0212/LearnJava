import java.util.*;

interface Selector {
    boolean end();

    Object current();

    void next();
}

public class Sequence {
    List<Object> objectList = new ArrayList();

    void add(Object object) {
        objectList.add(object);
    }

    public Selector selector() {
        return new InnerSelector();
    }

    private class InnerSelector implements Selector {
        private int i = 0;

        public boolean end() {
            return objectList.size() == i;
        }

        public Object current() {
            return objectList.get(i);
        }

        public void next() {
            i++;
        }
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10; ++i) {
            sequence.add(i);
        }
        Selector selector = sequence.selector();
        while (!selector.end()) {
            System.out.print("" + selector.current() + " ");
            selector.next();
        }
        System.out.println("");
    }
}