import java.util.*;

abstract class Test {
    void print() {
        System.out.println("Test");
    }
}

public class ExerciseTwo {
    public static void main(String[] args) {
        Test test = new Test();
    }
}