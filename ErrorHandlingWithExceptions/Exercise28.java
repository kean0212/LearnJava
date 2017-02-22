import java.util.*;

class MyException extends RuntimeException {
    String message;

    MyException(String message) {
        super(message);
        this.message = message;
    }

    String getmessage() {
        return message;
    }
}

public class Exercise28 {
    public static void main(String[] args) {
        throw new MyException("test");
    }
}