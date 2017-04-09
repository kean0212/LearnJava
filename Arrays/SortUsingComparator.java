import java.util.Comparator;
import java.util.Arrays;
import java.util.Random;

class ReverseIntegerComparator implements Comparator<Integer> {
    public int compare(Integer integerOne, Integer integerTwo) {
        return integerTwo - integerOne;
    }
}

public class SortUsingComparator {
    private static Random random = new Random(47);

    private static Integer[] generateArray(int size) {
        Integer[] integerArray = new Integer[size];
        for (int i = 0; i < size; ++i) {
            integerArray[i] = random.nextInt(10);
        }
        return integerArray;
    }

    public static void main(String[] args) {
        Integer[] integerArray = generateArray(10);
        System.out.println("before sorted: " + Arrays.toString(integerArray));

        Arrays.sort(integerArray, new ReverseIntegerComparator());
        System.out.println("after sorted: " + Arrays.toString(integerArray));
    }
}