import java.util.*;

public class OverloadThis {
    public static void main(String[] args) {
        Test test = new Test();
    }
}

class Test {
    Test() {
//        Test("hello");
//        this.Test("hello");
        this("hello");
        System.out.println("first constructor");
    }

    Test(String input) {
        System.out.println("second constructor");
    }
}