import java.util.ListIterator;
import java.util.List;

public class ListIteratorTest {
    // Test the basic methods of ListIterator
    private static void iterMotion(List<String> stringList) {
        ListIterator<String> listIterator = stringList.listIterator();
        Util.print("listIterator: " + listIterator);

        boolean hasNext = listIterator.hasNext();
        Util.print("hasNext(): " + hasNext); // true

        boolean hasPrevious = listIterator.hasPrevious();
        Util.print("hasPrevious(): " + hasPrevious); // false

        String string = listIterator.next();
        Util.print("next(): " + string); // "ALGERIA"

        int index = listIterator.nextIndex();
        Util.print("nextIndex(): " + index); // 1

        string = listIterator.previous();
        Util.print("previous(): " + string); // "ALGERIA"

        index = listIterator.previousIndex();
        Util.print("previousIndex(): " + index); // -1
    }

    private static void iterManipulation(List<String> stringList) {
        Util.print("---iterManipulation---");
        ListIterator<String> listIterator = stringList.listIterator();
        listIterator.add("47");
        Util.print("after inserting 47: " + stringList);
        Util.print("previousIndex(): " + listIterator.previousIndex());
        Util.print("nextIndex(): " + listIterator.nextIndex());

        String string = listIterator.next();
        Util.print("next(): " + string);

        listIterator.remove();
        Util.print("after removing: " + stringList);

        string = listIterator.next();
        Util.print("next(): " + string);

        listIterator.set("47");
        Util.print("after set: " + stringList);

        string = listIterator.previous();
        Util.print("previous(): "+ string);

        listIterator.set("74");
        Util.print("after set: " + stringList);

        listIterator.add("hello");
        Util.print("after adding hello: " + stringList);
        Util.print("previousIndex(): " + listIterator.previousIndex());
        Util.print("nextIndex(): " + listIterator.nextIndex());
    }

    public static void main(String[] args) {
        List<String> names = Countries.names(10);
        Util.print("Names: " + names);
        iterMotion(names);
        iterManipulation(names);
    }
}