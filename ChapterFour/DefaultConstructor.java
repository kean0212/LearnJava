import java.util.*;

public class DefaultConstructor {

    public static void main(String[] args) {
        Test test1 = new Test();
        Test test2 = new Test("haha");
    }
}

class Test {
    Test() {
        System.out.println("Constructor");
    }

    Test(String input) {
        System.out.println("Overloaded Constructor " + input);
    }
}