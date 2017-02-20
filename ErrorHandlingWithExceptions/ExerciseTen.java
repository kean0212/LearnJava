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

public class ExerciseTen {
    static void g() throws ExceptionOne {
        throw new ExceptionOne("Exception One");
    }

    static void f() throws ExceptionTwo {
        try {
            g();
        } catch (ExceptionOne exceptionOne) {
            throw new ExceptionTwo("Exception Two");
        }
    }

    public static void main(String[] args) {
        try {
            f();
        } catch (ExceptionTwo exceptionTwo) {
            exceptionTwo.printStackTrace(System.out);
        }
    }
}