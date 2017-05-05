import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.util.Map;
import java.util.AbstractMap;

public class SetFilling {
    private static void fillSetNTimes(Set<Map.Entry<String, String>> toSet, Set<Map.Entry<String, String>> fromSet, int times) {
        for (int i = 0; i < times; ++i) {
            for (Map.Entry<String, String> entry : fromSet) {
                toSet.add(new AbstractMap.SimpleEntry(entry.getKey(), entry.getValue()));
            }
        }
    }

    public static void main(String[] args) {
        Set<Map.Entry<String, String>> capitalSet = new HashSet<Map.Entry<String, String>>();
        for (Map.Entry<String, String> entry : Countries.capitals(10).entrySet()) {
            System.out.println("Successfully added [entry = " + entry + "]: " + capitalSet.add(entry));
        }
        System.out.println("WRONG Original capital set: " + capitalSet);
        // The output is 10 same entries
        /*
        Since there is only one Iterator in the EntrySet and only one Entry in the Iterator, when iterating through the
        entry set, the same entry with incremented index is added to the set mutiple times.

        The reason why the same entry can be successfully added to the set is that the hashcode changes. And the add
        method uses the hashcode to detect if the element exists in the set. Therefore, the same entry is added multiple
        times.

        Because the references are same, after the last iteration, the index in the entry (in the iterator) is updated to 9.
        Therefore, all elements in the set are the 9th element.
        */
        capitalSet = Countries.capitals(10).entrySet();
        System.out.println("RIGHT Original capital set: " + capitalSet);

        int times = 4;
        System.out.println("Times: " + times);

        Set<Map.Entry<String, String>> capitalHashSet = new HashSet<Map.Entry<String, String>>();
        fillSetNTimes(capitalHashSet, capitalSet, times);
        System.out.println("Filled capital hash set: " + capitalHashSet);

        Set<Map.Entry<String, String>> capitalLinkedHashSet = new LinkedHashSet<Map.Entry<String, String>>();
        fillSetNTimes(capitalLinkedHashSet, capitalSet, times);
        System.out.println("Filled capital linked hash set: " + capitalLinkedHashSet);

//        Set<Map.Entry<String, String>> capitalTreeSet = new TreeSet<Map.Entry<String, String>>();
//        fillSetNTimes(capitalTreeSet, capitalSet, 5);
//        System.out.println("Filled capital tree set: " + capitalTreeSet);
    }
}