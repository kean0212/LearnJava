import java.util.*;


public class ReferenceInitializationII {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.str);
    }
}

class Test {
    String str = "initialization"; // this is "package access"

    public Test() {
        str = "constructor"; // this will overwrite "initialization"
    }
}