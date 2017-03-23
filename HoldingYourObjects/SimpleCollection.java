import java.util.*;

public class SimpleCollection {
    static void fillAndPrintSet(Collection<Integer> set) {
        for (int i = 0; i < 10; ++i) {
            set.add(i);
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }
    }

    public static void main(String[] args) {
        Collection<Integer> integerHashSet = new HashSet<Integer>();
        System.out.println("Print out the hash set");
        fillAndPrintSet(integerHashSet);

        Collection<Integer> integerTreeSet = new TreeSet<Integer>();
        System.out.println("Print out the tree set");
        fillAndPrintSet(integerTreeSet);

        Collection<Integer> integerLinkedHashSet = new LinkedHashSet<Integer>();
        System.out.println("Print out the linked hash set");
        fillAndPrintSet(integerTreeSet);
    }
}