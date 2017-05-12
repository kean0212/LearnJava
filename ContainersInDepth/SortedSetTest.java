import java.util.List;
import java.util.Arrays;
import java.util.Comparator;

public class SortedSetTest {
    public static void main(String[] args) {
        String string = "This is a test for my the SortedSet implemented by LinkedList, which only takes " +
                "type implementing Comparable interface";
        List<String> stringList = Arrays.asList(string.split(" "));
        Util.print("stringList: " + stringList);

        SortedSet<String> sortedSet = new SortedSet<String>();
        sortedSet.addAll(stringList);
        Util.print("sortedSet: " + sortedSet);

        Util.print("first: " + sortedSet.first());
        Util.print("last: " + sortedSet.last());

        Util.print("sortedSet: " + sortedSet);
        String fromElement = "for";
        String toElement = "Comparable";
        SortedSet<String> subSet = sortedSet.subSet(fromElement, toElement);
        Util.print(String.format("invalid range [%s, %s): ", fromElement, toElement) + subSet);

        Util.print("sortedSet: " + sortedSet);
        fromElement = "this";
        toElement = "which";
        subSet = sortedSet.subSet(fromElement, toElement);
        Util.print(String.format("valid range with [%s, %s): ", fromElement, toElement) + subSet);

        Util.print("sortedSet: " + sortedSet);
        fromElement = "Comparable";
        subSet = sortedSet.tailSet(fromElement);
        Util.print(String.format("valid range with [%s, ): ", fromElement) + subSet);

        Util.print("sortedSet: " + sortedSet);
        fromElement = "B";
        subSet = sortedSet.tailSet(fromElement);
        Util.print(String.format("valid range with [%s, ): ", fromElement) + subSet);

        Util.print("sortedSet: " + sortedSet);
        fromElement = "y";
        subSet = sortedSet.tailSet(fromElement);
        Util.print(String.format("invalid range with [%s, ): ", fromElement) + subSet);

        Comparator<String> comparator = sortedSet.comparator();
        Util.print("Comparator: " + comparator);

        String stringOne = "hello";
        String stringTwo = "world";
        Util.print(String.format("Comparator.compare(%s, %s): ", stringOne, stringTwo) + comparator.compare(stringOne, stringTwo));
    }
}