import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

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
}

public class CustomizedClassSortAndBinarySearch {

    public static void main(String[] args) {
        sortAndBinarySearch();
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