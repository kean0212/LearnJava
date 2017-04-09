import java.util.Arrays;

class CompareTestClass {
    private int integer;

    public CompareTestClass(int integer) {
        this.integer = integer;
    }

    public String toString() {
        return "" + integer;
    }

    public boolean equals(Object another) {
        if (another == null || !(another instanceof CompareTestClass)) {
            return false;
        }
        return this.integer == ((CompareTestClass) another).integer;
    }

    public int getInteger() {
        return integer;
    }
}

public class CompareArrays {
    public static void main(String[] args) {
        int size = 10;
        CompareTestClass[] compareTestClassesOne = new CompareTestClass[size];
        for (int i = 0; i < 10; ++i) {
            compareTestClassesOne[i] = new CompareTestClass(5);
        }
        System.out.println(compareTestClassesOne + ": " + Arrays.toString(compareTestClassesOne));

        CompareTestClass[] compareTestClassesTwo = new CompareTestClass[size];
        for (int i = 0; i < 10; ++i) {
            compareTestClassesTwo[i] = new CompareTestClass(5);
        }
        System.out.println(compareTestClassesTwo + ": " + Arrays.toString(compareTestClassesTwo));

        System.out.println("array one == array two: " + Arrays.equals(compareTestClassesOne, compareTestClassesTwo));
    }
}