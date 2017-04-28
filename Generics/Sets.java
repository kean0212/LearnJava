import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;

public class Sets {
    public static <T> Set<T> union(Set<T> setOne, Set<T> setTwo) {
        Set<T> result = getNewSet(setOne);
        result.addAll(setTwo);
        return result;
    }

    public static <T> Set<T> intersection(Set<T> setOne, Set<T> setTwo) {
        Set<T> result = getNewSet(setOne);
        result.retainAll(setTwo);
        return result;
    }

    public static <T> Set<T> difference(Set<T> superSet, Set<T> subset) {
        Set<T> result = getNewSet(superSet);
        result.removeAll(subset);
        return result;
    }

    public static <T> Set<T> complement(Set<T> setOne, Set<T> setTwo) {
        return difference(union(setOne, setTwo), intersection(setOne, setTwo));
    }

    private static <T> Set<T> getNewSet(Set<T> originalSet) {
        if (originalSet instanceof EnumSet) {
            System.out.println("EnumSet.clone()");
            return ((EnumSet) originalSet).clone();
        }
        System.out.println("new HashSet<T>()");
        return new HashSet<T>(originalSet);
    }
}
