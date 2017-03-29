import java.util.*;

public class CopyUsingListIterator {
    public static void main(String[] args) {
        List<Integer> originalIntegerList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("original: " + originalIntegerList);

        List<Integer> copyIntegerList = new ArrayList<Integer>();
        for (ListIterator<Integer> listIterator = originalIntegerList.listIterator(); listIterator.hasNext(); ) {
            copyIntegerList.add(listIterator.next());
        }
        System.out.println("copy: " + copyIntegerList);

        List<Integer> secondCopyIntegerList = new ArrayList<Integer>();
        for (ListIterator<Integer> listIterator = originalIntegerList.listIterator(originalIntegerList.size());
             listIterator.hasPrevious(); ) {
            secondCopyIntegerList.add(listIterator.previous());
        }
        System.out.println("second copy: " + secondCopyIntegerList);
    }
}