import java.util.*;

class Test {
    Test() {
        System.out.println("Initialization");
    }
}

public class StringArrayReferences {
    public static void main(String[] args) {
        Test[] array = new Test[5];

        for (int i = 0; i < array.length; ++i) {
            array[i] = new Test();
        }
    }
}