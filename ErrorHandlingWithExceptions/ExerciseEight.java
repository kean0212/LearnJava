import java.util.*;

class MyException extends Exception {
    String message;

    MyException(String message) {
        super(message);
        this.message = message;
    }

    String getmessage() {
        return message;
    }
}

public class ExerciseEight {
    static void throwException() throws MyException {
        throw new MyException("test");
    }

    public static void main(String[] args) {
        try {
            throw new MyException("test");
        } catch (MyException exception) {
            System.out.println(exception.getmessage());
        }
    }
}