import java.util.*;

public class SynthesizedConstructor {
    public static void main(String[] args) {
        Test test = new Test();
        System.out.println("if this is output, then it means the constructor is synthesized.");
    }
}

class Test {
}