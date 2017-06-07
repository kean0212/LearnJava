import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.HashMap;

class Custom implements Comparable<Custom> {
    public final String first;
    public final String second;

    public Custom(String first, String second) {
        this.first = first;
        this.second = second;
    }

    public int compareTo(Custom other) {
        return first.compareTo(other.first);
    }

    public String toString() {
        return "{" + first + ", " + second + "}";
    }

    public boolean equals(Object other) {
        if (other instanceof Custom) {
            return first == ((Custom) other).first && second == ((Custom) other).second;
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 37 * result + first.hashCode();
        result = 37 * result + second.hashCode();
        return result;
    }
}

public class CustomizedClassSortAndBinarySearch {

    public static void main(String[] args) {
        Util.println("=====================");
        sortAndBinarySearchWithComparator();

        Util.println("=====================");
        sortAndBinarySearch();

        Util.println("=====================");
        HashSet<Custom> customHashSet = createHashSet(13, 1);
        Util.println("customHashSet: " + customHashSet);

        Util.println("=====================");
        HashMap<Custom, Integer> customIntegerHashMap = createHashMap(13, 1);
        Util.println("customHashMap: " + customIntegerHashMap);
    }

    private static void sortAndBinarySearchWithComparator() {
        Comparator<Custom> comparator = new Comparator<Custom>() {
            public int compare(Custom customOne, Custom customTwo) {
                return customOne.second.compareTo(customTwo.second);
            }
        };
        Custom[] customArray = createArray(10, 5);
        Custom customToBeSearched = customArray[2];
        Util.println("customArray: " + toString(customArray));
        Arrays.sort(customArray, comparator);
        Util.println("Arrays.sort(customArray, comparator): " + toString(customArray));
        Util.println("Arrays.binarySearch(customArray, " + customToBeSearched + ", comparator): " + Arrays.binarySearch(customArray, customToBeSearched, comparator));

        ArrayList<Custom> customArrayList = createArrayList(12, 6);
        customToBeSearched = customArrayList.get(2);
        Util.println("customArrayList: " + customArrayList);
        Collections.sort(customArrayList, comparator);
        Util.println("Collections.sort(customArrayList, comparator): " + customArrayList);
        Util.println("Collections.binarySearch(customArrayList, " + customToBeSearched + ", comparator): " + Collections.binarySearch(customArrayList, customToBeSearched, comparator));

    }

    private static void sortAndBinarySearch() {
        Custom[] customArray = createArray(10, 5);
        Custom customToBeSearched = customArray[2];
        Util.println("customArray: " + toString(customArray));
        Arrays.sort(customArray);
        Util.println("Arrays.sort(customArray): " + toString(customArray));
        Util.println("Arrays.binarySearch(customArray, " + customToBeSearched + "): " + Arrays.binarySearch(customArray, customToBeSearched));

        ArrayList<Custom> customArrayList = createArrayList(12, 6);
        customToBeSearched = customArrayList.get(2);
        Util.println("customArrayList: " + customArrayList);
        Collections.sort(customArrayList);
        Util.println("Collections.sort(customArrayList): " + customArrayList);
        Util.println("Collections.binarySearch(customArrayList, " + customToBeSearched + "): " + Collections.binarySearch(customArrayList, customToBeSearched));
    }

    private static HashSet<Custom> createHashSet(int size, int length) {
        RandomGenerator.String stringGenerator = new RandomGenerator.String(length);
        HashSet<Custom> customHashSet = new HashSet<>();
        for (int i = 0; i < size; ++i) {
            customHashSet.add(new Custom(stringGenerator.next(), stringGenerator.next()));
        }
        return customHashSet;
    }

    private static HashMap<Custom, Integer> createHashMap(int size, int length) {
        RandomGenerator.String stringGenerator = new RandomGenerator.String(length);
        HashMap<Custom, Integer> customHashMap = new HashMap<>();
        for (int i = 0; i < size; ++i) {
            customHashMap.put(new Custom(stringGenerator.next(), stringGenerator.next()), i);
        }
        return customHashMap;
    }

    private static Custom[] createArray(int size, int length) {
        RandomGenerator.String stringGenerator = new RandomGenerator.String(length);
        Custom[] customArray = new Custom[size];
        for (int i = 0; i < size; ++i) {
            customArray[i] = new Custom(stringGenerator.next(), stringGenerator.next());
        }
        return customArray;
    }

    private static ArrayList<Custom> createArrayList(int size, int length) {
        RandomGenerator.String stringGenerator = new RandomGenerator.String(length);
        ArrayList<Custom> customArrayList = new ArrayList<>();
        for (int i = 0; i < size; ++i) {
            customArrayList.add(new Custom(stringGenerator.next(), stringGenerator.next()));
        }
        return customArrayList;
    }

    private static String toString(Custom[] customArray) {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (Custom custom : customArray) {
            stringBuilder.append(custom);
            stringBuilder.append(", ");
        }
        int length = stringBuilder.length();
        stringBuilder.delete(length - 2, length);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}