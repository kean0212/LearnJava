import java.util.*;

class Test {
    static String string1 = "hello";
    static String string2;

    static {
        string2 = "world";
    }

    static void print() {
        System.out.println(string1);
        System.out.println(string2);
    }
}

public class StaticString {
    public static void main(String[] args) {
        Test test = new Test();
        test.print();
    }
}