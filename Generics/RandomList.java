import java.util.ArrayList;
import java.util.Random;

public class RandomList<T> {
    private Random random = new Random(31);
    private ArrayList<T> storage = new ArrayList<T>();

    public void add(T element) {
        storage.add(element);
    }

    public T select() {
        return storage.get(random.nextInt(storage.size()));
    }

    public static void main(String[] args) {
        // Random list of integers
        RandomList<Integer> integerRandomList = new RandomList<Integer>();
        for (int i = 0; i < 10; ++i) {
            integerRandomList.add(i);
        }
        System.out.println("Random list of Integers: " + integerRandomList);
        for (int i = 0; i < 10; ++i) {
            System.out.print(integerRandomList.select() + " ");
        }
        System.out.println("");

        // Random list of Strings
        RandomList<String> stringRandomList = new RandomList<String>();
        for (String string : "this is a test for random list".split(" ")) {
            stringRandomList.add(string);
        }
        for (int i = 0; i < 10; ++i) {
            System.out.print(stringRandomList.select() + " ");
        }
        System.out.println("");
    }
}