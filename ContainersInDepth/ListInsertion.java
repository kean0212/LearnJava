import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListInsertion {
    private static String toStringWithIterator(String testCase, List<String> list) {
        StringBuffer stringBuffer = new StringBuffer(testCase + ": [");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            stringBuffer.append(iterator.next() + ", ");
        }
        int stringBufferLength = stringBuffer.length();
        stringBuffer.delete(stringBufferLength - 2, stringBufferLength);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    private static void forwardInsertion(List<String> toList, List<String> fromList) {
        ListIterator<String> listIteratorOfToList = toList.listIterator();
        ListIterator<String> listIteratorOfFromList = fromList.listIterator();
        while (listIteratorOfToList.hasNext() && listIteratorOfFromList.hasNext()) {
            listIteratorOfToList.add(listIteratorOfFromList.next());
            listIteratorOfToList.next();
        }
        while (listIteratorOfFromList.hasNext()) {
            listIteratorOfToList.add(listIteratorOfFromList.next());
        }
    }

    private static void backwardInsertion(List<String> toList, List<String> fromList) {
        ListIterator<String> listIteratorOfToList = toList.listIterator(toList.size() - 1);
        ListIterator<String> listIteratorOfFromList = fromList.listIterator();
        while (listIteratorOfFromList.hasNext()) {
            listIteratorOfToList.add(listIteratorOfFromList.next());
            listIteratorOfToList.previous();
            if (listIteratorOfToList.hasPrevious()) {
                listIteratorOfToList.previous();
            }
        }
    }

    private static void insertionTest(int toListSize, int fromListSize, boolean isForward) {
        Util.print("###############################");
        List<String> toList = new ArrayList<String>(Countries.names(toListSize));
        Util.print(toStringWithIterator("toList", toList));

        List<String> fromList = new LinkedList<String>(Countries.names(fromListSize));
        Util.print(toStringWithIterator("fromList", fromList));

        String testCase;
        if (isForward) {
            forwardInsertion(toList, fromList);
            testCase = "Forward inserted list";
        } else {
            backwardInsertion(toList, fromList);
            testCase = "Backward inserted list";
        }
        Util.print(toStringWithIterator(testCase, toList));
    }

    public static void main(String[] args) {
        int listSize = 10;
        List<String> stringArrayList = new ArrayList<String>(Countries.names(listSize));
        Util.print(toStringWithIterator("Initial stringArrayList", stringArrayList));
        List<String> stringLinkedList = new LinkedList<String>(Countries.names(listSize));
        Util.print(toStringWithIterator("Initial stringLinkedList", stringLinkedList));

        insertionTest(5, 5, true);
        insertionTest(8, 5, true);
        insertionTest(5, 8, true);

        insertionTest(5, 5, false);
        insertionTest(8, 5, false);
        insertionTest(5, 8, false);
    }
}
