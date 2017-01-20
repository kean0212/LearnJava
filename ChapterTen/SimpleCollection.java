import java.util.*;

public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> integers = new ArrayList<Integer>();

        for (int i = 0; i < 10; ++i) {
            integers.add(i);
            integers.add(i);
        }

        for (Integer i: integers) {
            System.out.println(i);
        }
    }
}