import java.util.*;

public class InsertToMiddleUsingListIterator {
    static void insertToMiddle(LinkedList<Integer> list, int element) {
        ListIterator listIterator = list.listIterator(list.size() / 2);
        listIterator.add(element);
    }

    public static void main(String[] args) {
        LinkedList<Integer> integerLinkedList = new LinkedList<Integer>();
        int[] integerArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int element : integerArray) {
            insertToMiddle(integerLinkedList, element);
        }
        System.out.println(integerLinkedList);
    }
}