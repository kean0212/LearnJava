import java.util.Arrays;
import java.util.Random;

public class UnpredictableBinarySearch {
    private static Random random = new Random(47);

    private static int[] generateArray(int size) {
        int[] intArray = new int[size];
        for (int i = 0; i < size; ++i) {
            intArray[i] = random.nextInt(10);
        }
        return intArray;
    }

    private static String find(int[] intArray, int element) {
        int index = Arrays.binarySearch(intArray, element);
        return (index < 0 ? "Not found: " : "Found at index ") + index;
    }

    public static void main(String[] args) {
        int[] intArray = generateArray(10);
        int index = 5;
        System.out.println(Arrays.toString(intArray) + " search element " + index);
        System.out.println(find(intArray, intArray[index]));
    }
}