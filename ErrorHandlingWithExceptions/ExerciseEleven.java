import java.util.*;

class ExceptionOne extends Exception {
    ExceptionOne(String message) {
        super(message);
    }
}

class ExceptionTwo extends Exception {
    ExceptionTwo(String message) {
        super(message);
    }
}

public class ExerciseEleven {
    static void g() throws ExceptionOne {
        throw new ExceptionOne("Exception One");
    }

    static void f() throws RuntimeException {
        try {
            g();
        } catch (ExceptionOne exceptionOne) {
            throw new RuntimeException(exceptionOne);
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }
    }
}