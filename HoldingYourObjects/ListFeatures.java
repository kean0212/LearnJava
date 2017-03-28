import java.util.*;

public class ListFeatures {
    static List<Integer> createList(int count) {
        Random random = new Random(212);
        List<Integer> integerList = new ArrayList();
        for (int i = 0; i < count; ++i) {
            integerList.add(random.nextInt(100));
        }
        return integerList;
    }

    static void print(String prefix, Object list) {
        System.out.println(prefix + list);
    }

    public static void main(String[] args) {
        List<Integer> list = createList(10);
        print("Initial list: ", list);

        Integer temp = 212;
        list.add(temp);
        print("Add 212: ", list);

        print("list contains 212: ", list.contains(temp)); // the equals of Integer is not based on reference, I bet

        list.remove(temp);
        print("Removed 212: ", list);

        Integer element = list.get(2); // todo: my question is that how does it know whether it's index or the object? - it can only be index
        print("Index of element should be 2? ", list.indexOf(element));

        print("Index of 212: ", list.indexOf(temp));
        print("Remove 212: ", list.remove(temp)); // todo: see what if the list does NOT contain 212? - return false

        print("Current list: ", list);
        list.add(3, 212);
        print("Add 212 to the 3rd position: ", list);

        List<Integer> sublist = list.subList(1, 4);
        print("sublist starting from 1st: ", sublist);

        print("list contains sublist? ", list.containsAll(sublist));

        Collections.sort(sublist); // in-place sorting
        print("sorted sublist: ", sublist);

        print("list contains sorted sublist: ", list.containsAll(sublist));

        Random random = new Random(212);
        Collections.shuffle(sublist, random); // in-place shuffling
        print("shuffled sublist: ", sublist);

        print("list contains shuffled sublist: ", list.containsAll(sublist));

        List<Integer> copy = new ArrayList<Integer>(list);
        print("copy: ", copy);

        sublist = Arrays.asList(list.get(1), list.get(4));
        print("sublist: ", sublist);

        copy.retainAll(sublist); // todo: replace the list with sublist? - yes
        print("copy after retainAll: ", copy);

        copy = new ArrayList<Integer>(list);
        copy.remove(2); // todo: remove by index?
        print("with the second removed: ", copy);

        copy.removeAll(sublist); // in-place remove
        print("with sublist removed: ", copy);

        copy.set(1, 212);
        print("with 1st element set to 212: ", copy);

        copy.addAll(2, sublist);
        print("sublist: ", sublist);
        print("with sublist inserted at the 2nd position: ", copy);

        print("list empty? ", list.isEmpty());
        list.clear();
        print("list after clear: ", copy);
        print("after clear, list empty? ", list.isEmpty());

        list.addAll(createList(4));
        Object[] unmutableArray = list.toArray(); // todo: this converts to array, is it mutable? - of course, it's mutable

        print("3rd of the array: ", unmutableArray[2]);

        Integer[] array = list.toArray(new Integer[0]);
        print("3rd of the array: ", array[2]);
    }
}