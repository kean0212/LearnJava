import java.util.*;

public class IteratorForAllCollectionTypes {
    public static Collection fill(Collection<String> collection) {
        collection.add("dog");
        collection.add("cat");
        collection.add("rodent");
        collection.add("goose");
        return collection;
    }

    public static void print(Iterator iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Collection collection = fill(new ArrayList<String>());
        print(collection.iterator());

        collection = fill(new LinkedList<String>());
        print(collection.iterator());

        collection = fill(new HashSet<String>());
        print(collection.iterator());

        collection = fill(new TreeSet<String>());
        print(collection.iterator());

        collection = fill(new LinkedHashSet<String>());
        print(collection.iterator());
    }
}