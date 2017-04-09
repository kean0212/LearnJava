import java.util.Arrays;

class TestClass {
    public int integer;

    public TestClass(int integer) {
        this.integer = integer;
    }

    public String toString() {
        return "" + integer;
    }
}

public class TestArraysFill {
    public static void main(String[] args) {
        // case 1
        String[] stringArrayOne = new String[10];
        System.out.println("before string array one: " + Arrays.toString(stringArrayOne));
        Arrays.fill(stringArrayOne, "hello");
        System.out.println("after string array one: " + Arrays.toString(stringArrayOne));
        stringArrayOne[2] = "world";
        System.out.println("after change of element, string array one: " + Arrays.toString(stringArrayOne));

        // case 2
        String[] stringArrayTwo = new String[10];
        String element = "hello";
        Arrays.fill(stringArrayTwo, element);
        System.out.println("before the change of element, string array two: " + Arrays.toString(stringArrayTwo));
        element = "world";
        System.out.println("after the change of element, string array two: " + Arrays.toString(stringArrayTwo));

        // case 3 - customized class
        TestClass[] testClasses = new TestClass[10];
        Arrays.fill(testClasses, new TestClass(2));
        System.out.println("before change, test class array: " + Arrays.toString(testClasses));
        testClasses[2].integer = 3;
        System.out.println("after change, test class array: " + Arrays.toString(testClasses));
    }
}