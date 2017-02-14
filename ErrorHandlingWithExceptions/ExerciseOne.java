import java.util.*;

class MyException extends Exception {
    MyException() {
        System.out.println("Exception constructor without string input.");
    }

    MyException(String message) {
        super(message);
        System.out.println("Exception constructor with string input.");
    }
}

public class ExerciseOne {
    public static void main(String[] args) {
        try {
            throw new MyException("Test");
        } catch (MyException e) {
            System.out.println("MyException is caught!");
        } finally {
            System.out.println("main function is aborting!");
        }
    }
}