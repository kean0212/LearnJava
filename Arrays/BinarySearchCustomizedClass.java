import java.util.Arrays;
import java.util.Comparator;

class TestClassComparator implements Comparator<CompareTestClass> {
    public int compare(CompareTestClass objectOne, CompareTestClass objectTwo) {
        return objectOne.getInteger() - objectTwo.getInteger();
    }
}

public class BinarySearchCustomizedClass {
    public static void main(String[] args) {
        CompareTestClass[] compareTestClassArray = {
                new CompareTestClass(3), new CompareTestClass(6), new CompareTestClass(9),
                new CompareTestClass(4), new CompareTestClass(2), new CompareTestClass(7),
                new CompareTestClass(8), new CompareTestClass(5), new CompareTestClass(1)
        };

        System.out.println("Before sorted: " + Arrays.toString(compareTestClassArray));
        Arrays.sort(compareTestClassArray, new TestClassComparator());
        System.out.println("After sorted: " + Arrays.toString(compareTestClassArray));

        int index = 3;
        System.out.println(index + " is found at " +
                Arrays.binarySearch(compareTestClassArray, new CompareTestClass(3), new TestClassComparator()));
    }
}