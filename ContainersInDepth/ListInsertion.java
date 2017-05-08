import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class ListInsertion {
    private static String toStringWithIterator(String listType, List<String> list) {
        StringBuffer stringBuffer = new StringBuffer(listType + ": [");
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

    public static void main(String[] args) {
        int listSize = 10;
        List<String> stringArrayList = new ArrayList<String>(Countries.names(listSize));
        Util.print(toStringWithIterator("Initial stringArrayList", stringArrayList));
        List<String> stringLinkedList = new LinkedList<String>(Countries.names(listSize));
        Util.print(toStringWithIterator("Initial stringLinkedList", stringLinkedList));

        List<String> forwardStringArrayList = new ArrayList<String>(stringArrayList);
        List<String> forwardStringLinkedList = new LinkedList<String>(stringLinkedList);
        Util.print(toStringWithIterator("Forward inserted stringArraylist",
                forwardInsertion(forwardStringArrayList, forwardStringLinkedList);))
    }
}
