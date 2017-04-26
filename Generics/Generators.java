import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.Random;

interface Generator<T> {
    T next();
}

class RandomIntegerGenerator implements Generator<Integer> {
    private static Random random = new Random(31);

    public Integer next() {
        return random.nextInt(47);
    }
}

public class Generators {
    public static <T> Collection<T> fill(Collection<T> collection, Generator<T> generator, int size) {
        for (int i = 0; i < size; ++i) {
            collection.add(generator.next());
        }
        return collection;
    }

    public static <T> List<T> fill(List<T> list, Generator<T> generator, int size) {
        for (int i = 0; i < size; ++i) {
            list.add(generator.next());
        }
        return list;
    }

    public static <T> LinkedList<T> fill(LinkedList<T> linkedList, Generator<T> generator, int size) {
        for (int i = 0; i < size; ++i) {
            linkedList.add(generator.next());
        }
        return linkedList;
    }

    public static <T> Set<T> fill(Set<T> set, Generator<T> generator, int size) {
        for (int i = 0; i < size; ++i) {
            set.add(generator.next());
        }
        return set;
    }

    public static <T> Queue<T> fill(Queue<T> queue, Generator<T> generator, int size) {
        for (int i = 0; i < size; ++i) {
            queue.add(generator.next());
        }
        return queue;
    }

    public static <T> void printCollection(Collection<T> collection) {
        System.out.println(collection.getClass().getSimpleName() + ": ");
        for (T element : collection) {
            System.out.print(element + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        RandomIntegerGenerator randomIntegerGenerator = new RandomIntegerGenerator();
        int size = 10;

        Collection<Integer> collection = fill(new ArrayList<Integer>(), randomIntegerGenerator, size);
        printCollection(collection);

        List<Integer> list = fill(new ArrayList<Integer>(), randomIntegerGenerator, size);
        printCollection(list);

        Set<Integer> set = fill(new HashSet<Integer>(), randomIntegerGenerator, size);
        printCollection(set);

        Queue<Integer> queue = fill((Queue<Integer>) new LinkedList<Integer>(), randomIntegerGenerator, size);
        printCollection(queue);

        LinkedList<Integer> linkedList = fill(new LinkedList<Integer>(), randomIntegerGenerator, size);
        printCollection(queue);
    }
}