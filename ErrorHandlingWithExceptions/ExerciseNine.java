import java.util.*;

class ExceptionOne extends Exception {
}

class ExceptionTwo extends Exception {
}

class ExceptionThree extends Exception {
}

public class ExerciseNine {
    static Random random = new Random(212);

    static void f() throws ExceptionOne, ExceptionTwo, ExceptionThree {
        switch (random.nextInt(3)) {
            case 0:
                throw new ExceptionOne();
            case 1:
                throw new ExceptionTwo();
            case 2:
                throw new ExceptionThree();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; ++i) {
            try {
                f();
            } catch (Exception exception) {
                exception.printStackTrace(System.out);
            }
        }
    }

}
